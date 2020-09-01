#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution{
public:
    string longestCommonPrefix(vector<string>& strs){
        if (strs.size() == 0) return "";
        string res = strs[0];
        for(int i = 1; i < strs.size(); i++){
            int j = 0;
            for(j = 0; j < res.length() && j < strs[i].length(); j++){
                if(res[j] != strs[i][j]) break;
            }
            res = res.substr(0, j);
            if (res == "") return res;
        }
        return res;
    }
};

int main()
{
    vector<string> strs = { "aaab","aab","aavvd" };
    Solution S;
    string res = S.longestCommonPrefix(strs);
    cout << res << endl;
    return 0;
}

//Java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length()-1);
            }
            i++;
        }
        return res;
    }
}