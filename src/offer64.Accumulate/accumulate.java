//1
class Solution {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1; // 进位
            a ^= b; //非进位
            b = c;
        }
        return a;
    }
}
//2
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0); 
        return sum;
    }
}
//3
public class Solution {
    public int Sum_Solution(int n) {
        int res = 0;
        int a = n;
        int b = n + 1;
        while(a != 0){
            if((a & 1) == 1){
                res += b;
            }
            a >>= 1;
            b <<= 1;
        }
        return res>>=1;
    }
}
//4
public class Solution {
    public int Sum_Solution(int n) {
        return (int)(Math.pow(n,2) + n) >> 1;
    }
}