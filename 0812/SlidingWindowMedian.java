import java.util.*;

public class SlidingWindowMedian {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
            if (i >= k) removeNum(nums[i - k]);
            if (i >= k - 1) result[i - k + 1] = getMedian();
        }
        return result;
    }

    private void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    private void removeNum(int num) {
        if (num <= maxHeap.peek()) maxHeap.remove(num);
        else minHeap.remove(num);
        if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
    }

    private double getMedian() {
        if (maxHeap.size() == minHeap.size())
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        double[] res = swm.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
/*
 * Time Complexity: O(n log k)
 */
