#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        vector<int>vec_x;
        while(x)
        {
            vec_x.push_back(x%10);
            x = x/10;
        }
        int len = vec_x.size();
        int i = 0, j = len-1;
        for(i = 0; i<len; i++)
        {
            if(vec_x[i] != vec_x[j-i])
                return false;
            
        }
        return true;
    }
};

class Solution2{
public:
    bool isPalindrome(int x){
        if(x<0) return false;
        if((x%10==0) && x!=0) return false;
        int revert = 0;
        while(x > revert)
        {
            revert = revert*10 + x%10;
            x /= 10;
        }
        if(x == revert || (x == (revert/10)))
            return true;
        return false;
    }
};

int main()
{
    int x = 10;
    Solution2 A;
    bool res = A.isPalindrome(x);
    cout << res << endl;
    return 0;
}