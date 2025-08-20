import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry{int time,list,idx;Entry(int t,int l,int i){time=t;list=l;idx=i;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        List<int[]> lists=new ArrayList<>();
        for(int i=0;i<K;i++){
            int len=sc.nextInt();
            int[] arr=new int[len];
            for(int j=0;j<len;j++) arr[j]=sc.nextInt();
            lists.add(arr);
        }
        sc.close();
        PriorityQueue<Entry> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        for(int i=0;i<K;i++) if(lists.get(i).length>0) pq.offer(new Entry(lists.get(i)[0],i,0));
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            Entry e=pq.poll();
            res.add(e.time);
            if(e.idx+1<lists.get(e.list).length)
                pq.offer(new Entry(lists.get(e.list)[e.idx+1],e.list,e.idx+1));
        }
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i));
            if(i<res.size()-1) System.out.print(" ");
        }
    }
}

