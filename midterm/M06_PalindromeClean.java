import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)) sb.append(Character.toLowerCase(c));
        }
        String cleaned=sb.toString();
        System.out.println(isPalindrome(cleaned)?"Yes":"No");
    }

    static boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
