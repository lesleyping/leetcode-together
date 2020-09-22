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
            res += exp(len-1);
        }else if(first == 1){
            res += 1 + Integer.parseInt(str.substring(index+1));
        }
        res += first * (len - 1) * exp(len - 2);
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
                res += high * digit + low + 1;
            }else if(cur == 0){
                res += high * digit;
            }else if(cur > 1 && cur < 10){
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
