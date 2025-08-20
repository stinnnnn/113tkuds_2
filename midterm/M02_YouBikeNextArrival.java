import java.util.*;

public class M02_YouBikeNextArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = toMinutes(sc.nextLine().trim());
        int query = toMinutes(sc.nextLine().trim());
        sc.close();

        int idx = Arrays.binarySearch(times, query+1);
        if (idx < 0) idx = -idx - 1;

        if (idx < n) System.out.println(toHHmm(times[idx]));
        else System.out.println("No bike");
    }

    static int toMinutes(String s) {
        String[] p = s.split(":");
        return Integer.parseInt(p[0])*60 + Integer.parseInt(p[1]);
    }

    static String toHHmm(int m) {
        return String.format("%02d:%02d", m/60, m%60);
    }
}