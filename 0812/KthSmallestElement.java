import java.util.*;

public class KthSmallestElement {

    // 方法1: 使用大小為 K 的 Max Heap
    public static int kthSmallestMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    // 方法2: 使用 Min Heap 提取 K 次
    public static int kthSmallestMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.offer(num);
        for (int i = 1; i < k; i++) minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallestMaxHeap(arr1, 3)); // 7
        System.out.println(kthSmallestMinHeap(arr1, 3)); // 7
    }
}
/*
 * 方法1: O(n log k)
 * 方法2: O(n + k log n)
 */
