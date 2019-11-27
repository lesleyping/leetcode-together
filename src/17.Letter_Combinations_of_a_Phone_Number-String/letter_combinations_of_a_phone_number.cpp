#include<iostream>
#include<vector>
#include<string>
#include<map>
using namespace std;

class Solution{
public:
    vector<string> res;
    string cur;
    map<char, string> table{{'2', "abc"},{'3', "edf"},{'4', "ghi"},{'5', "jkl"},{'6', "mno"},{'7', "pqrs"},{'8', "tuv"},{'9', "wxyz"}};
    vector<string> letterCombinations(string digits){
        
        if(digits.length() == 0) return res;
        DFS(digits);
        return res;
    }
    void DFS(string digit){
        if(!digit.size()) res.push_back(cur);
        else{
            char num = digit[0];
            string letter = table[num];
            for(int i = 0; i < letter.size(); i++){
                cur.push_back(letter[i]);
                DFS(digit.substr(1));
                cur.pop_back();
            }
        }
    }
};

int main()
{
    string digits = "254";
    Solution S;
    vector<string> res = S.letterCombinations(digits);
    for(int i = 0; i < res.size(); i++){
        cout << res[i] << endl;
    }
    return 0;
}