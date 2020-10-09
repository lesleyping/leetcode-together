public class Solution {
    public int Fibonacci(int n) {
        int fib1 = 0;
        int fib2 = 1;
        if(n <= 1){
            return n;
        }
        int res = 0;
        for(int i = 2; i <= n; i++){
            res = fib2 + fib1;
            fib1 = fib2;
            fib2 = res;
        }
        return res;
    }
}