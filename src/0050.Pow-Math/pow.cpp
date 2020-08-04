#include<iostream>
#include<math.h>
using namespace std;

class Solution{
public:
    double myPow(double x, int n){
        if(n == 0) return 1.0;
        double res = 1;
        int b = abs(n);
        while(b){
            if(b&1) res = res*x;
            b >>= 1;
            x *= x;
        }
        if(n<0) res = 1/res;
        return res; 
    }
};

int main()
{
    double x = 2.00000;
    int n = -1;
    Solution S;
    double res = S.myPow(x,n);
    cout << res << endl;
    return 0;
}