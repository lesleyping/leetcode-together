#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution{
public:
    bool isMatch(string s,string p){
        int m = s.length();
        int n = p.length();
        vector<vector<bool> > res(m+1, vector<bool>(n+1, false));
        res[0][0] = true;
        for(int i = 0; i <= n; i++){
            if(res[0][i] && p[i] == '*'){
                res[0][i+1] = true;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p[j] == '*'){
                    res[i+1][j+1] = res[i+1][j] || res[i][j+1] ;
                }
                else if(p[j] == '?' || s[i]==p[j]){
                    res[i+1][j+1] = res[i][j];
                }
            }
        }
        return res[m][n];
    }
};

int main()
{
    string s = "aaaa";
    string p = "a*?j";
    Solution S;
    bool res = S.isMatch(s, p);
    cout << res << endl;
    return 0;
}