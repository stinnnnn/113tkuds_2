import java.io.*;
import java.util.*;

public class lt_40_CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // 去重
            if (candidates[i] > remain) break; // 剪枝
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] candidates = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> ans = combinationSum2(candidates, target);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
