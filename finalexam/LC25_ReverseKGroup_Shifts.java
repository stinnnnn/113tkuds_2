import java.io.*;
import java.util.*;

public class LC25_ReverseKGroup_Shifts {
    static class ListNode{int val;ListNode next;ListNode(int v){val=v;}}
    static ListNode reverse(ListNode start,ListNode end){
        ListNode prev=end.next,cur=start;
        while(prev!=end){
            ListNode nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return end;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine().trim());
        String line=br.readLine();if(line==null)line="";
        StringTokenizer st=new StringTokenizer(line);
        ListNode dummy=new ListNode(0),cur=dummy;
        while(st.hasMoreTokens()){cur.next=new ListNode(Integer.parseInt(st.nextToken()));cur=cur.next;}
        ListNode groupPrev=dummy;
        while(true){
            ListNode kth=groupPrev;
            for(int i=0;i<k&&kth!=null;i++)kth=kth.next;
            if(kth==null)break;
            ListNode groupNext=kth.next;
            ListNode start=groupPrev.next;
            reverse(start,kth);
            groupPrev.next=kth;
            start.next=groupNext;
            groupPrev=start;
        }
        cur=dummy.next;List<String> out=new ArrayList<>();
        while(cur!=null){out.add(String.valueOf(cur.val));cur=cur.next;}
        if(!out.isEmpty())System.out.println(String.join(" ",out));
    }
}

