#include<iostream>
#include<string>
#include<stack>
#include<vector>
#include<algorithm>

using namespace std;

#define max(a,b) (((a) > (b)) ? (a) : (b))

class Solution{                              //timeout
public:
    bool isValid(string s){
        stack<char> vec;
        for(int i = 0; i<s.length(); i++){
            if(s[i] == '('){
                vec.push(s[i]);
            }
            else if(s[i] == ')' && !vec.empty()){
                vec.pop();
            }
            else{
                return false;
            }
        }
        return vec.empty();
    }

    int longestValidParentheses(string s){
        if (s.length()<2) return 0;
        int maxlen = 0;
        for(int i = 0; i<s.length()-1; i++){
            for(int j = 2; i+j<=s.length(); j=j+2){
                if(isValid(s.substr(i,j))){
                    maxlen = max(maxlen,j);
                }
            }
        }
        return maxlen;
    }
};

class Solution2{
public:
    int longestValidParentheses(string s){
        if(s.length()<2) return 0;
        int len = s.length();
        vector<int> res(len);
        
        for(int i = 1; i<s.length(); i++){
            if(s[i] == ')'){
                if(s[i-1] == '(') 
                    {
                        res[i] = (2 + (i > 2 ? res[i-2] : 0));
                    }
                else if( (i - res[i-1]) > 0 && s[i-res[i-1]-1] == '(') 
                    {
                        res[i] = (2 + res[i-1] + ((i-res[i-1] >= 2) ? res[i-res[i-1]-2] : 0));
                    }
            }
        }
        
        auto maxlen = max_element(res.begin(), res.end());
        return res[maxlen - res.begin()];
    }
};



int main()
{
    string s = "))()())";
    Solution2 S;
    int res = S.longestValidParentheses(s);
    cout << res << endl;
    return 0;
}