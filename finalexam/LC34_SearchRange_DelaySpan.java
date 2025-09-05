import java.io.*;
import java.util.*;

public class LC34_SearchRange_DelaySpan {
    static int lowerBound(int[] a,int target){
        int l=0,r=a.length;
        while(l<r){
            int mid=(l+r)/2;
            if(a[mid]<target)l=mid+1;else r=mid;
        }return l;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),target=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        if(n>0){st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)arr[i]=Integer.parseInt(st.nextToken());}
        if(n==0){System.out.println("-1 -1");return;}
        int l=lowerBound(arr,target);
        if(l==n||arr[l]!=target){System.out.println("-1 -1");return;}
        int r=lowerBound(arr,target+1)-1;
        System.out.println(l+" "+r);
    }
}
