import java.util.*;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong(), b=sc.nextLong();
        sc.close();
        long g=gcd(a,b);
        long l=a/g*b;
        System.out.println("GCD: "+g);
        System.out.println("LCM: "+l);
    }

    static long gcd(long x,long y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
}
/*
 * Time Complexity: O(log(min(a,b)))
 * 說明：歐幾里得演算法每次取餘數遞迴，最大遞迴深度 O(log(min(a,b)))。
 */
