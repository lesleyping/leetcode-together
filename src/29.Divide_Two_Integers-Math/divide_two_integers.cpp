#include<iostream>
#include<math.h>
#include<limits.h>
using namespace std;

class Solution{
public:
    int divide(int dividend, int divisor){
        long res = 0;
        long a = labs(dividend), b = labs(divisor);
        while(a>=b){
            long times = 1, temp = b;
            while(a >= (temp<<1)){
                times <<= 1;
                temp <<= 1;
            }
            res += times;
            a -= temp;
        }
        res = ((dividend > 0) ^ (divisor > 0)) ? -res : res;
        return (res > INT_MAX || res < INT_MIN) ? INT_MAX : res;
    }
};

int main()
{
    int dividend = 19;
    int divisor = 3;
    Solution S;
    int res = S.divide(dividend, divisor);
    cout << res << endl;
    return 0;
}