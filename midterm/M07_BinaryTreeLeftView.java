import java.util.*;

public class M07_BinaryTreeLeftView {
    static class Node{int val;Node left,right;Node(int v){val=v;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            int v=sc.nextInt();arr[i]=(v==-1?null:v);
        }
        sc.close();
        Node root=build(arr,0);
        List<Integer> res=leftView(root);
        System.out.print("LeftView:");
        for(int v:res) System.out.print(" "+v);
    }
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node node=new Node(arr[i]);
        node.left=build(arr,2*i+1);
        node.right=build(arr,2*i+2);
        return node;
    }
    static List<Integer> leftView(Node root){
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(i==0) res.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return res;
    }
}
