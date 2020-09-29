public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            return "";
        }
        int s1 = 0, e1 = n - 1;
        int s2 = n, e2 = str.length() - 1;
        char[] c = str.toCharArray();
        Reverse(c, s1, e1);
        Reverse(c, s2, e2);
        Reverse(c, s1, e2);
        return new String(c);
    }
    private void Reverse(char[] c, int l, int r){
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