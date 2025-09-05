import java.io.*;
import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        String first = fs.next();
        if (first == null) return; // 無輸入
        int n = Integer.parseInt(first);
        long target = Long.parseLong(fs.next());
        long[] seats = new long[n];
        for (int i = 0; i < n; i++) seats[i] = Long.parseLong(fs.next());

        // HashMap<需要的數, 索引>
        Map<Long, Integer> need = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = seats[i];
            if (need.containsKey(x)) {
                System.out.println(need.get(x) + " " + i);
                return;
            }
            need.put(target - x, i);
        }
        System.out.println("-1 -1");
    }
}
