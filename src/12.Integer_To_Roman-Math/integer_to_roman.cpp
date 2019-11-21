#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution{
public:
    string intToRoman(int num){
        vector<int> values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        vector<string> strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        string res;
        for(int i = 0; i < values.size(); i++){
            while(num >= values[i]){
                res += strs[i];
                num -= values[i];
            }
        }
        return res;
    }
};

int main()
{
    int num = 58;
    Solution S;
    string res = S.intToRoman(num);
    cout << res << endl;
    return 0;
}