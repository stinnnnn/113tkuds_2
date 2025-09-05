import java.io.*;
import java.util.*;

public class LC21_MergeTwoLists_Clinics {
    static class ListNode{int val;ListNode next;ListNode(int v){val=v;}}
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        ListNode dummy1=new ListNode(0),cur=dummy1;
        for(int i=0;i<n;i++){cur.next=new ListNode(Integer.parseInt(st.nextToken()));cur=cur.next;}
        st=new StringTokenizer(br.readLine());
        ListNode dummy2=new ListNode(0);cur=dummy2;
        for(int i=0;i<m;i++){cur.next=new ListNode(Integer.parseInt(st.nextToken()));cur=cur.next;}
        ListNode l1=dummy1.next,l2=dummy2.next;
        ListNode dummy=new ListNode(0);cur=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){cur.next=l1;l1=l1.next;}
            else{cur.next=l2;l2=l2.next;}
            cur=cur.next;
        }
        cur.next=(l1!=null)?l1:l2;
        List<String> out=new ArrayList<>();
        cur=dummy.next;while(cur!=null){out.add(String.valueOf(cur.val));cur=cur.next;}
        System.out.println(String.join(" ",out));
    }
}
