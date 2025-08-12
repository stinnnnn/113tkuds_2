import java.util.*;

class ArrayEntry {
    int value, arrIdx, elemIdx;
    ArrayEntry(int value, int arrIdx, int elemIdx) {
        this.value = value;
        this.arrIdx = arrIdx;
        this.elemIdx = elemIdx;
    }
}

public class MergeKSortedArrays {
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new ArrayEntry(arrays[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            ArrayEntry cur = minHeap.poll();
            result.add(cur.value);
            if (cur.elemIdx + 1 < arrays[cur.arrIdx].length) {
                minHeap.offer(new ArrayEntry(arrays[cur.arrIdx][cur.elemIdx + 1], cur.arrIdx, cur.elemIdx + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1,4,5}, {1,3,4}, {2,6}};
        System.out.println(mergeKSortedArrays(arrays));
    }
}
/*
 * Time Complexity: O(N log k) (N = 總元素數量, k = 陣列數)
 */
