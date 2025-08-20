import java.util.*;

public class M04_TieredTaxSimple {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim());
        long sum=0;
        for(int i=0;i<n;i++){
            long x=Long.parseLong(sc.nextLine().trim());
            long tax=compute(x);
            System.out.println("Tax: "+tax);
            sum+=tax;
        }
        System.out.println("Average: "+(sum/n));
    }

    static long compute(long x){
        long tax=0;
        if(x<=120000) tax=(long)(x*0.05);
        else if(x<=500000) tax=(long)(120000*0.05+(x-120000)*0.12);
        else if(x<=1000000) tax=(long)(120000*0.05+(500000-120000)*0.12+(x-500000)*0.20);
        else tax=(long)(120000*0.05+(500000-120000)*0.12+(1000000-500000)*0.20+(x-1000000)*0.30);
        return tax;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每筆收入計算稅額是 O(1)，共 n 筆輸入總和 O(n)。
 */