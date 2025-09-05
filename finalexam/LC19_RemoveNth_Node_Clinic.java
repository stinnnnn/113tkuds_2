import java.io.*;
import java.util.*;

public class LC19_RemoveNth_Node_Clinic {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        StringTokenizer st=new StringTokenizer(br.readLine());
        ListNode dummy=new ListNode(0),cur=dummy;
        for(int i=0;i<n;i++){
            cur.next=new ListNode(Integer.parseInt(st.nextToken()));
            cur=cur.next;
        }
        int k=Integer.parseInt(br.readLine().trim());
        ListNode fast=dummy,slow=dummy;
        for(int i=0;i<k;i++)fast=fast.next;
        while(fast.next!=null){fast=fast.next;slow=slow.next;}
        slow.next=slow.next.next;
        cur=dummy.next;
        List<String> out=new ArrayList<>();
        while(cur!=null){out.add(String.valueOf(cur.val));cur=cur.next;}
        if(out.isEmpty())System.out.println();
        else System.out.println(String.join(" ",out));
    }
}
