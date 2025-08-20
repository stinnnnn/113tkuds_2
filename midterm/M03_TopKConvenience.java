import java.util.*;

public class M03_TopKConvenience {
    static class Item {
        String name; int qty;
        Item(String n,int q){name=n;qty=q;}
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), K=sc.nextInt();
        List<Item> items=new ArrayList<>();
        for(int i=0;i<n;i++){
            String name=sc.next();
            int qty=sc.nextInt();
            items.add(new Item(name,qty));
        }
        sc.close();

        PriorityQueue<Item> pq=new PriorityQueue<>(
            (a,b)-> a.qty==b.qty ? a.name.compareTo(b.name) : a.qty-b.qty
        );

        for(Item it:items){
            pq.offer(it);
            if(pq.size()>K) pq.poll();
        }

        List<Item> res=new ArrayList<>(pq);
        res.sort((a,b)-> b.qty==a.qty? a.name.compareTo(b.name): b.qty-a.qty);

        for(Item it:res) System.out.println(it.name+" "+it.qty);
    }
}
/*
 * Time Complexity: O(n log K)
 * 說明：每筆資料維護最小堆，插入/刪除成本 O(log K)，總共 n 筆 O(n log K)。
 */