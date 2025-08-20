import java.util.*;

public class M09_AVLValidate {
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
        if(!isBST(root,Long.MIN_VALUE,Long.MAX_VALUE))
            System.out.println("Invalid BST");
        else if(!isAVL(root).valid)
            System.out.println("Invalid AVL");
        else System.out.println("Valid");
    }
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node node=new Node(arr[i]);
        node.left=build(arr,2*i+1);
        node.right=build(arr,2*i+2);
        return node;
    }
    static boolean isBST(Node node,long min,long max){
        if(node==null) return true;
        if(node.val<=min||node.val>=max) return false;
        return isBST(node.left,min,node.val)&&isBST(node.right,node.val,max);
    }
    static class Info{boolean valid;int height;Info(boolean v,int h){valid=v;height=h;}}
    static Info isAVL(Node node){
        if(node==null) return new Info(true,0);
        Info L=isAVL(node.left), R=isAVL(node.right);
        if(!L.valid||!R.valid) return new Info(false,0);
        if(Math.abs(L.height-R.height)>1) return new Info(false,0);
        return new Info(true,Math.max(L.height,R.height)+1);
    }
}
/*
 * Time Complexity: O(n)
 * 說明：檢查 BST 與 AVL 都需遍歷一次所有節點，每節點處理 O(1)，總成本 O(n)。
 */
