#include<iostream>

using namespace std;

class Solution{
public:
    int climbStairs(int n){
        int res = 0;
        int one = 1;
        int two = 2;
        for(int i = 3; i <= n; i++){
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
};

int main()
{
    int n = 3;
    Solution S;
    int res = S.climbStairs(n);
    cout << res << endl;
    return 0;
}