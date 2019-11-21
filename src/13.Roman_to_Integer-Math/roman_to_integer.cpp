#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>
using namespace std;

class Solution{
public:
    int romanToInt(string s){
        unordered_map<char, int> m = {{'M',1000},{'D',500},{'C',100},{'L',50},{'X',10},{'V',5},{'I',1}};
        int res = m[s[0]];
        for(int i = 1; i < s.length(); i++){
            int flag = m[s[i-1]];
            if(m[s[i]]>flag) res = res + m[s[i]] - 2 * flag;
            else res += m[s[i]];
        }
        return res;
    }
};

int main()
{
    string s = "LVIII";
    Solution S;
    int res = S.romanToInt(s);
    cout << res << endl;
    return 0;
}