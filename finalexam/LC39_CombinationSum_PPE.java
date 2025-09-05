import java.io.*;
import java.util.*;

public class LC39_CombinationSum_PPE {
    static void dfs(int[] cand,int idx,int remain,List<Integer>cur,List<List<Integer>>ans){
        if(remain==0){ans.add(new ArrayList<>(cur));return;}
        if(remain<0)return;
        for(int i=idx;i<cand.length;i++){
            cur.add(cand[i]);
            dfs(cand,i,remain-cand[i],cur,ans);
            cur.remove(cur.size()-1);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),target=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] cand=new int[n];for(int i=0;i<n;i++)cand[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(cand);
        List<List<Integer>> ans=new ArrayList<>();
        dfs(cand,0,target,new ArrayList<>(),ans);
        for(List<Integer> comb:ans){
            System.out.println(comb.toString().replaceAll("[\\[\\],]","").trim());
        }
    }
}
