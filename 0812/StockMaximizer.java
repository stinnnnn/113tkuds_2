import java.util.*;

public class StockMaximizer {
    public static int maxProfit(int[] prices, int k) {
        List<Integer> profits = new ArrayList<>();
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profits.add(prices[i] - prices[i - 1]);
            }
        }
        profits.sort(Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < Math.min(k, profits.size()); i++) total += profits.get(i);
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1}, 2)); // 2
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}, 2)); // 7
    }
}
/*
 * Time Complexity: O(n log n)
 */
