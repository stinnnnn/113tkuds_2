import java.util.*;

public class MovingAverageStream {
    private Queue<Integer> window;
    private int size;
    private double sum;
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MovingAverageStream(int size) {
        this.size = size;
        this.window = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        window.offer(val);
        sum += val;
        maxHeap.offer(val);
        minHeap.offer(val);
        if (window.size() > size) {
            int removed = window.poll();
            sum -= removed;
            maxHeap.remove(removed);
            minHeap.remove(removed);
        }
        return sum / window.size();
    }

    public double getMedian() {
        List<Integer> sorted = new ArrayList<>(window);
        Collections.sort(sorted);
        int n = sorted.size();
        if (n % 2 == 1) return sorted.get(n/2);
        return (sorted.get(n/2 - 1) + sorted.get(n/2)) / 2.0;
    }

    public int getMin() {
        return minHeap.peek();
    }

    public int getMax() {
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MovingAverageStream ma = new MovingAverageStream(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
        System.out.println(ma.getMedian());
        System.out.println(ma.getMin());
        System.out.println(ma.getMax());
    }
}
/*
 * Time Complexity: next O(log n), getMedian O(n)
 */

