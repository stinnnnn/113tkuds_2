import java.util.*;

public class M10_RBPropertiesCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] vals=new int[n]; char[] colors=new char[n];
        for(int i=0;i<n;i++){ vals[i]=sc.nextInt(); colors[i]=sc.next().charAt(0); }
        sc.close();
        if(n==0){System.out.println("RB Valid");return;}
        if(colors[0]!='B'){System.out.println("RootNotBlack");return;}
        if(checkRedRed(vals,colors)) return;
        int bh=checkBH(vals,colors,0);
        if(bh==-1) System.out.println("BlackHeightMismatch");
        else System.out.println("RB Valid");
    }
    static boolean checkRedRed(int[] vals,char[] colors){
        for(int i=0;i<vals.length;i++){
            if(vals[i]==-1) continue;
            int l=2*i+1,r=2*i+2;
            if(colors[i]=='R'){
                if(l<vals.length&&vals[l]!=-1&&colors[l]=='R'){
                    System.out.println("RedRedViolation at index "+l);
                    return true;
                }
                if(r<vals.length&&vals[r]!=-1&&colors[r]=='R'){
                    System.out.println("RedRedViolation at index "+r);
                    return true;
                }
            }
        }
        return false;
    }
    static int checkBH(int[] vals,char[] colors,int i){
        if(i>=vals.length||vals[i]==-1) return 1;
        int L=checkBH(vals,colors,2*i+1),R=checkBH(vals,colors,2*i+2);
        if(L==-1||R==-1||L!=R) return -1;
        return L+(colors[i]=='B'?1:0);
    }
}

