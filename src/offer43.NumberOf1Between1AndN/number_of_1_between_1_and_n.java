//1
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n < 0){
            return 0;
        }
        String str = String.valueOf(n);
        int res = getNumberOf1(str, 0);
        return res;
    }
    public int getNumberOf1(String str, int index){
        int len = str.length()-index;
        if(len == 1 && str.charAt(index) == '0'){
            return 0;
        }
        if(len == 1){
            return 1;
        }
        int first = str.charAt(index) - '0';
        int res = 0;
        if(first > 1){
            //最高位不是1 ，结果为10000（19999-10000），
            res += exp(len-1);
        }else if(first == 1){
            //最高位（1234）为1，结果是235
            res += 1 + Integer.parseInt(str.substring(index+1));
        }
        //（除去最高位，其余每位取1，其他位置可以任意选10个数）
        res += first * (len - 1) * exp(len - 2);
        //去掉最高位后的递归
        res += getNumberOf1(str, index+1);
        return res;
    }
    public int exp(int n){
        int res = 1;
        while(n >= 1){
            res *= 10;
            n--;
        }
        return res;
    }
}
//2
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cur = n % 10;
        int low = 0;
        int high = n / 10;
        int digit = 1;
        int res = 0;
        while(high != 0 || cur != 0){
            if(cur == 1){
                //该位为1时，左右来决定
                res += high * digit + low + 1;
            }else if(cur == 0){
                //该位为0时，左决定
                res += high * digit;
            }else if(cur > 1 && cur < 10){
                //其他情况，左决定
                res += (high + 1) * digit;
            }
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }
}

//-------------second
