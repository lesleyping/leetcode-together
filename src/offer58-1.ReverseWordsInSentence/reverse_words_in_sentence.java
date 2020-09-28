//leetcode可通过
//对空格没有处理
//1
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> str = Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
        return String.join(" ", str);
    }
}
//2
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int j = s.length() - 1;
        int i = j;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i+1, j+1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
//剑指offer版本
import java.util.*;
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null){
            return "";
        }
        char[] c = str.toCharArray();
        for(int i = 0, l = 0; i <= c.length; i++){
            if(i == c.length || c[i] == ' '){
                reverse(c, l, i - 1);
                l = i + 1;
            }
        }
        reverse(c, 0, c.length-1);
        return new String(c);
    }
    private void reverse(char[] c, int l, int r){
        while(l < r){
            swap(c, l++, r--);
        }
    }
    private void swap(char[] c, int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}