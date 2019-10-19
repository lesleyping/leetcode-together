#include<string>
#include<iostream>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int i = 0;
        int flag = 1;
        int len = str.length();
        int num = 0;
        while(str[i] == ' ') i++;
        if(str[i] == '-') flag = -1;
        if(str[i] == '+' || str[i] == '-') i++;
        while(i < len && isdigit(str[i]))
        {
            int nn = str[i] - '0';
            if(num > INT_MAX/10 || (num == INT_MAX/10 && nn > 7) )
            {
                if(flag>0) return INT_MAX;
                else
                    return INT_MIN;
            }
            num = num*10 + nn;
            i++;
        }
        return flag>0 ? num : -num;
    }
};

int main()
{
    string a = "    -324 3";
    Solution A;
    int result = A.myAtoi(a);
    cout << result << endl;
    return 0;
}