import java.io.*;
import java.util.*;

public class LC33_SearchRotated_RentHot {
    static class FastScanner{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next()throws IOException{
            while(st==null||!st.hasMoreTokens()){
                String line=br.readLine();if(line==null)return null;
                st=new StringTokenizer(line);
            }return st.nextToken();
        }
    }
    public static void main(String[] args)throws Exception{
        FastScanner fs=new FastScanner();
        int n=Integer.parseInt(fs.next());int target=Integer.parseInt(fs.next());
        int[] arr=new int[n];for(int i=0;i<n;i++)arr[i]=Integer.parseInt(fs.next());
        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==target){System.out.println(mid);return;}
            if(arr[l]<=arr[mid]){
                if(arr[l]<=target&&target<arr[mid])r=mid-1;else l=mid+1;
            }else{
                if(arr[mid]<target&&target<=arr[r])l=mid+1;else r=mid-1;
            }
        }
        System.out.println(-1);
    }
}

