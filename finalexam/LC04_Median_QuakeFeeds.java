import java.io.*;
import java.util.*;

public class LC04_Median_QuakeFeeds {
    static class FastScanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        String t = fs.next();
        if (t == null) return;
        int n = Integer.parseInt(t);
        int m = Integer.parseInt(fs.next());

        double[] A = new double[n];
        double[] B = new double[m];
        for (int i = 0; i < n; i++) A[i] = Double.parseDouble(fs.next());
        for (int j = 0; j < m; j++) B[j] = Double.parseDouble(fs.next());

        // 確保 A 是較短的陣列
        if (n > m) {
            double[] tmp = A; A = B; B = tmp;
            int tt = n; n = m; m = tt;
        }

        int totalLeft = (n + m + 1) / 2;
        int lo = 0, hi = n;

        // 以 ±INF 處理邊界
        final double NEG_INF = -1e300, POS_INF = 1e300;

        while (lo <= hi) {
            int i = (lo + hi) / 2;       // A 左半取 i 個
            int j = totalLeft - i;       // B 左半取 j 個

            double Aleft  = (i == 0) ? NEG_INF : A[i - 1];
            double Aright = (i == n) ? POS_INF : A[i];
            double Bleft  = (j == 0) ? NEG_INF : B[j - 1];
            double Bright = (j == m) ? POS_INF : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                double median;
                if (((n + m) & 1) == 1) {
                    median = Math.max(Aleft, Bleft);
                } else {
                    median = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
                System.out.printf(Locale.US, "%.1f%n", median);
                return;
            } else if (Aleft > Bright) {
                hi = i - 1;  // i 太大，往左縮
            } else {
                lo = i + 1;  // i 太小，往右擴
            }
        }
    }
}
