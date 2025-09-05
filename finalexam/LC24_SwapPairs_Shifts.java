import java.io.*;
import java.util.*;

public class LC24_SwapPairs_Shifts {
    static class ListNode{int val;ListNode next;ListNode(int v){val=v;}}
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        if(line==null||line.trim().isEmpty()){System.out.println();return;}
        StringTokenizer st=new StringTokenizer(line);
        ListNode dummy=new ListNode(0),cur=dummy;
        while(st.hasMoreTokens()){cur.next=new ListNode(Integer.parseInt(st.nextToken()));cur=cur.next;}
        ListNode prev=new ListNode(0);prev.next=dummy.next;dummy=prev;
        while(prev.next!=null&&prev.next.next!=null){
            ListNode a=prev.next,b=a.next;
            a.next=b.next;b.next=a;prev.next=b;prev=a;
        }
        cur=dummy.next;List<String> out=new ArrayList<>();
        while(cur!=null){out.add(String.valueOf(cur.val));cur=cur.next;}
        System.out.println(String.join(" ",out));
    }
}
