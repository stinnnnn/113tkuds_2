import java.io.*;
import java.util.*;

public class LC27_RemoveElement_Recycle {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),val=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];for(int i=0;i<n;i++)arr[i]=Integer.parseInt(st.nextToken());
        int write=0;
        for(int x:arr)if(x!=val)arr[write++]=x;
        System.out.println(write);
        for(int i=0;i<write;i++){System.out.print(arr[i]);if(i<write-1)System.out.print(" ");}
        if(write>0)System.out.println();
    }
}

