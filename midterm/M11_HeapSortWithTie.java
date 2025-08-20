import java.util.*;

public class M11_HeapSortWithTie {
    static class Pair{int score,idx;Pair(int s,int i){score=s;idx=i;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pair[] arr=new Pair[n];
        for(int i=0;i<n;i++) arr[i]=new Pair(sc.nextInt(),i);
        sc.close();
        Arrays.sort(arr,(a,b)->{
            if(a.score!=b.score) return a.score-b.score;
            return a.idx-b.idx;
        });
        for(int i=0;i<n;i++){
            System.out.print(arr[i].score);
            if(i<n-1) System.out.print(" ");
        }
    }
}
/*
 * Time Complexity: O(n log n)
 * 說明：排序需要 O(n log n)，比較依據分數與索引，單次比較 O(1)。
 */

