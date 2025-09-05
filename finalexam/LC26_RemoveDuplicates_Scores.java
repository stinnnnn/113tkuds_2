import java.io.*;
import java.util.*;

public class LC26_RemoveDuplicates_Scores {
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
        String t=fs.next();if(t==null)return;
        int n=Integer.parseInt(t);
        if(n==0){System.out.println(0);return;}
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=Integer.parseInt(fs.next());
        int write=1;
        for(int i=1;i<n;i++)if(arr[i]!=arr[write-1])arr[write++]=arr[i];
        System.out.println(write);
        for(int i=0;i<write;i++){System.out.print(arr[i]);if(i<write-1)System.out.print(" ");}
        System.out.println();
    }
}
