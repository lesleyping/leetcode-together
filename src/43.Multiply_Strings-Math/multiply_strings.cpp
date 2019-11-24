#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution{
public:
    string multiply(string num1, string num2){
        int n1 = num1.length();
        int n2 = num2.length();
        string res(n1+n2,'0');
        for(int i = n1-1; i >= 0; i--){
            for(int j = n2-1; j >= 0; j--){
                int tmp = (res[i+j+1] - '0')+(num1[i] - '0') * (num2[j] - '0');
                res[i+j+1] = tmp%10 + '0';
                res[i+j] += tmp/10;
            }
        }
        for(int i = 0; i<n1+n2; i++){
            if(res[i] != '0')
                return res.substr(i);
        }
        return "0";
    }
};

int main()
{
    string num1 = "123";
    string num2 = "345";
    Solution S;
    string res = S.multiply(num1, num2);
    cout << res << endl;
    return 0;
}