import java.util.*;

class CacheEntry {
    int key;
    String value;
    int freq;
    long time;
    CacheEntry(int key, String value, int freq, long time) {
        this.key = key; this.value = value; this.freq = freq; this.time = time;
    }
}

public class MultiLevelCacheSystem {
    private Map<Integer, CacheEntry> L1 = new HashMap<>();
    private Map<Integer, CacheEntry> L2 = new HashMap<>();
    private Map<Integer, CacheEntry> L3 = new HashMap<>();
    private int cap1 = 2, cap2 = 5, cap3 = 10;
    private long timestamp = 0;

    public String get(int key) {
        timestamp++;
        if (L1.containsKey(key)) { L1.get(key).freq++; return L1.get(key).value; }
        if (L2.containsKey(key)) { L2.get(key).freq++; promote(L2, L1, key, cap1); return L1.get(key).value; }
        if (L3.containsKey(key)) { L3.get(key).freq++; promote(L3, L2, key, cap2); return L2.get(key).value; }
        return null;
    }

    public void put(int key, String value) {
        timestamp++;
        if (L1.containsKey(key)) { L1.get(key).value = value; return; }
        if (L2.containsKey(key)) { L2.get(key).value = value; return; }
        if (L3.containsKey(key)) { L3.get(key).value = value; return; }
        CacheEntry entry = new CacheEntry(key, value, 1, timestamp);
        if (L1.size() < cap1) { L1.put(key, entry); return; }
        promote(L1, L2, getEvictKey(L1), cap2);
        L1.put(key, entry);
    }

    private void promote(Map<Integer, CacheEntry> from, Map<Integer, CacheEntry> to, int key, int cap) {
        CacheEntry entry = from.remove(key);
        if (to.size() >= cap) {
            promote(to, getNextLevel(to), getEvictKey(to), getCap(getNextLevel(to)));
        }
        to.put(entry.key, entry);
    }

    private Map<Integer, CacheEntry> getNextLevel(Map<Integer, CacheEntry> map) {
        if (map == L1) return L2;
        if (map == L2) return L3;
        return L3;
    }

    private int getCap(Map<Integer, CacheEntry> map) {
        if (map == L1) return cap1;
        if (map == L2) return cap2;
        return cap3;
    }

    private int getEvictKey(Map<Integer, CacheEntry> map) {
        return map.entrySet().stream()
                .min(Comparator.comparing((Map.Entry<Integer, CacheEntry> e) -> e.getValue().freq)
                        .thenComparing(e -> e.getValue().time))
                .get().getKey();
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);
        cache.get(1);
        cache.get(2);
        cache.put(4, "D");
        cache.put(5, "E");
        cache.put(6, "F");
    }
}
/*
 * Time Complexity: O(log n) for eviction and promotion
 */
