import java.io.*;
import java.util.*;

public class LC03_NoRepeat_TaipeiMetroTap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) s = "";  // 處理空輸入

        // 紀錄每個字元上次出現的位置
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0, best = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 若字元已經出現過，且位置 >= left，更新左界
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }

            lastIndex.put(c, i); // 更新最後出現位置
            best = Math.max(best, i - left + 1);
        }

        System.out.println(best);
    }
}
