import java.io.*;

public class lt_38_CountAndSay {
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = encode(res);
        }
        return res;
    }

    private static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(countAndSay(n));
    }
}
