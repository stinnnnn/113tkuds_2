// File: lt_01_TwoSum.java

import java.util.HashMap;

public class lt_01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // 不會發生（題目保證有解）
    }

    // 測試用 main
    public static void main(String[] args) {
        lt_01_TwoSum solver = new lt_01_TwoSum();
        int[] res = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}
