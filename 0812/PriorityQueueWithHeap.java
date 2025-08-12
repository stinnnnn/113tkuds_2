import java.util.*;

class Task {
    String name;
    int priority;
    long timestamp;

    Task(String name, int priority, long timestamp) {
        this.name = name;
        this.priority = priority;
        this.timestamp = timestamp;
    }
}

public class PriorityQueueWithHeap {
    private PriorityQueue<Task> pq;
    private long counter = 0;

    public PriorityQueueWithHeap() {
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return Long.compare(a.timestamp, b.timestamp);
        });
    }

    public void addTask(String name, int priority) {
        pq.offer(new Task(name, priority, counter++));
    }

    public String executeNext() {
        return pq.isEmpty() ? null : pq.poll().name;
    }

    public String peek() {
        return pq.isEmpty() ? null : pq.peek().name;
    }

    public void changePriority(String name, int newPriority) {
        List<Task> tasks = new ArrayList<>(pq);
        pq.clear();
        for (Task t : tasks) {
            if (t.name.equals(name)) t.priority = newPriority;
            pq.offer(t);
        }
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap q = new PriorityQueueWithHeap();
        q.addTask("備份", 1);
        q.addTask("緊急修復", 5);
        q.addTask("更新", 3);

        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
    }
}
/*
 * Time Complexity:
 * addTask: O(log n)
 * executeNext: O(log n)
 * changePriority: O(n log n)
 */
