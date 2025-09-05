import java.io.*;
import java.util.*;

public class LC11_MaxArea_FuelHoliday {
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
        long[] h=new long[n];
        for(int i=0;i<n;i++)h[i]=Long.parseLong(fs.next());
        int l=0,r=n-1; long best=0;
        while(l<r){
            long area=(long)(r-l)*Math.min(h[l],h[r]);
            if(area>best)best=area;
            if(h[l]<h[r])l++; else r--;
        }
        System.out.println(best);
    }
}
