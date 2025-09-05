import java.io.*;
import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) s = "";

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    System.out.println("false");
                    return;
                }
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "true" : "false");
    }
}
