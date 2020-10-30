public class Solution {
    private int idx = 0;
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        boolean numeric = scanInteger(str);
        //.左右两边只要出现数值即可
        //.后面不可以接 有符号数字
        if(idx < str.length && str[idx] == '.'){
            idx++;
            numeric |= scanUnsignedInteger(str);
        }
        //e左右两边必须都要有数值
        //e后面可以接 有符号数字
        if(idx < str.length && (str[idx] == 'e' || str[idx] == 'E')){
            idx++;
            numeric = numeric && scanInteger(str);
        }
        return numeric && (idx == str.length);
    }

    private boolean scanUnsignedInteger(char[] str){
        int tmp = idx;
        while(idx < str.length && str[idx] >= '0' && str[idx] <= '9'){
            idx++;
        }
        return idx > tmp;
    }
    private boolean scanInteger(char[] str){
        if(idx < str.length && (str[idx] == '+' || str[idx] == '-')){
            idx++;
        }
        return scanUnsignedInteger(str);
    }
}