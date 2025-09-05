import java.io.*;
import java.util.*;

public class lt_31_NextPermutationMain {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1. 從右找第一個下降點
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. 從右找第一個比 nums[i] 大的數
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 反轉 i+1 ~ n-1
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) throws IOException {
        // 輸入格式：
        // n
        // n 個整數
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        nextPermutation(nums);

        // 輸出結果
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
