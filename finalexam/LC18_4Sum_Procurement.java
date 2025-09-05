import java.io.*;
import java.util.*;

public class LC18_4Sum_Procurement {
    static class FastScanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        String next() throws IOException {
            while(st==null||!st.hasMoreTokens()){
                String line=br.readLine();
                if(line==null)return null;
                st=new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }
    public static void main(String[] args)throws Exception{
        FastScanner fs=new FastScanner();
        int n=Integer.parseInt(fs.next());
        long target=Long.parseLong(fs.next());
        long[] a=new long[n];
        for(int i=0;i<n;i++)a[i]=Long.parseLong(fs.next());
        Arrays.sort(a);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i>0&&a[i]==a[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&a[j]==a[j-1])continue;
                int L=j+1,R=n-1;
                while(L<R){
                    long sum=a[i]+a[j]+a[L]+a[R];
                    if(sum==target){
                        sb.append(a[i]).append(" ").append(a[j]).append(" ").append(a[L]).append(" ").append(a[R]).append("\n");
                        long vL=a[L],vR=a[R];
                        while(L<R&&a[L]==vL)L++;
                        while(L<R&&a[R]==vR)R--;
                    }else if(sum<target)L++;
                    else R--;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
