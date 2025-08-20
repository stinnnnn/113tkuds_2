import java.util.*;

public class M08_BSTRangedSum {
    static class Node{int val;Node left,right;Node(int v){val=v;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            int v=sc.nextInt();arr[i]=(v==-1?null:v);
        }
        int L=sc.nextInt(), R=sc.nextInt();
        sc.close();
        Node root=build(arr,0);
        int sum=rangeSum(root,L,R);
        System.out.println("Sum: "+sum);
    }
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node node=new Node(arr[i]);
        node.left=build(arr,2*i+1);
        node.right=build(arr,2*i+2);
        return node;
    }
    static int rangeSum(Node root,int L,int R){
        if(root==null) return 0;
        if(root.val<L) return rangeSum(root.right,L,R);
        if(root.val>R) return rangeSum(root.left,L,R);
        return root.val+rangeSum(root.left,L,R)+rangeSum(root.right,L,R);
    }
}

