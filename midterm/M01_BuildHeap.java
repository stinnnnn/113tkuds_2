import java.util.*;

public class M01_BuildHeap {
    static String type;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        type = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sc.close();

        buildHeap(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
    }

    static void buildHeap(int[] arr, int n) {
        for (int i = n/2 - 1; i >= 0; i--) heapifyDown(arr, n, i);
    }

    static void heapifyDown(int[] arr, int n, int i) {
        int target = i, l = 2*i+1, r = 2*i+2;
        if (type.equals("max")) {
            if (l < n && arr[l] > arr[target]) target = l;
            if (r < n && arr[r] > arr[target]) target = r;
        } else {
            if (l < n && arr[l] < arr[target]) target = l;
            if (r < n && arr[r] < arr[target]) target = r;
        }
        if (target != i) {
            int tmp = arr[i]; arr[i] = arr[target]; arr[target] = tmp;
            heapifyDown(arr, n, target);
        }
    }
}
/*
 * Time Complexity: O(n)
 * 說明：自底向上建堆，每個節點下沉操作平均成本小於 log n，總合約 2n ≈ O(n)。
 */
