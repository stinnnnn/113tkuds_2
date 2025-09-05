import java.io.*;

public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String haystack=br.readLine();if(haystack==null)haystack="";
        String needle=br.readLine();if(needle==null)needle="";
        if(needle.isEmpty()){System.out.println(0);return;}
        for(int i=0;i+needle.length()<=haystack.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                System.out.println(i);return;
            }
        }
        System.out.println(-1);
    }
}

