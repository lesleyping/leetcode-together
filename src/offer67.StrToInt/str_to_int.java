public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] s = str.trim().toCharArray();
        if(s.length == 0){
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(s[0] == '-'){
            sign = -1;
        }else if(s[0] != '+'){
            i = 0;
        }
        for (int j = i; j < s.length; j++){
            if(s[j] < '0' || s[j] > '9'){
                return 0;
            }
            if(res > bndry || (res == bndry && s[j] > '7')){
                return sign == 1 ? Integer.MIN_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s[j] - '0');
        }
        return sign * res;
    }
}