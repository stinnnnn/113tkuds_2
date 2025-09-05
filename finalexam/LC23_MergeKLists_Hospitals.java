import java.io.*;
import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode{int val;ListNode next;ListNode(int v){val=v;}}
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine().trim());
        List<ListNode> lists=new ArrayList<>();
        for(int i=0;i<k;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            ListNode dummy=new ListNode(0),cur=dummy;
            while(st.hasMoreTokens()){
                int v=Integer.parseInt(st.nextToken());
                if(v==-1)break;
                cur.next=new ListNode(v);cur=cur.next;
            }
            lists.add(dummy.next);
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>(Comparator.comparingInt(x->x.val));
        for(ListNode node:lists)if(node!=null)pq.add(node);
        ListNode dummy=new ListNode(0),cur=dummy;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            cur.next=node;cur=cur.next;
            if(node.next!=null)pq.add(node.next);
        }
        List<String> out=new ArrayList<>();
        cur=dummy.next;while(cur!=null){out.add(String.valueOf(cur.val));cur=cur.next;}
        if(!out.isEmpty())System.out.println(String.join(" ",out));
    }
}

