#include<iostream>
#include<string>
#include<stack>
using namespace std;

class Solution{
public:
    bool isValid(string s){
        stack<char> res;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
                res.push(s[i]);
            }
            else if(!res.empty()){
                if(res.top() == '(' && s[i] == ')') res.pop();
                else if(res.top() == '{' && s[i] == '}') res.pop();
                else if(res.top() == '[' && s[i] == ']') res.pop();
                else return false;
            }
            else return false;
        }
        return res.empty();
    }
};

int main()
{
    string s = "()(]";
    Solution S;
    bool res = S.isValid(s);
    cout << res << endl;
    return 0;
}