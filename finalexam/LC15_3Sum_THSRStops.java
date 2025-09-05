import java.io.*;
import java.util.*;

public class LC15_3Sum_THSRStops {
    static class FastScanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        String next() throws IOException {
            while (st==null||!st.hasMoreTokens()) {
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
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=Integer.parseInt(fs.next());
        Arrays.sort(a);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i>0&&a[i]==a[i-1])continue;
            if(a[i]>0)break;
            int L=i+1,R=n-1;
            while(L<R){
                int sum=a[i]+a[L]+a[R];
                if(sum==0){
                    sb.append(a[i]).append(" ").append(a[L]).append(" ").append(a[R]).append("\n");
                    int vL=a[L],vR=a[R];
                    while(L<R&&a[L]==vL)L++;
                    while(L<R&&a[R]==vR)R--;
                }else if(sum<0)L++; else R--;
            }
        }
        System.out.print(sb.toString());
    }
}
