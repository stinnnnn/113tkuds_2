import java.io.*;
import java.util.*;

public class LC17_PhoneCombos_CSShift {
    static String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void dfs(char[] d,int idx,StringBuilder cur,List<String>out){
        if(idx==d.length){out.add(cur.toString());return;}
        String letters=map[d[idx]-'2'];
        for(int i=0;i<letters.length();i++){
            cur.append(letters.charAt(i));
            dfs(d,idx+1,cur,out);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String digits=br.readLine();
        if(digits==null)digits="";
        digits=digits.trim();
        if(digits.isEmpty())return;
        List<String> ans=new ArrayList<>();
        dfs(digits.toCharArray(),0,new StringBuilder(),ans);
        for(String s:ans)System.out.println(s);
    }
}
