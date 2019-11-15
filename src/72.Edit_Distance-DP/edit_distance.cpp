#include<iostream>
#include<string>
#include<vector>
using namespace std;
#define mina(a,b) ((a) < (b) ? (a) : (b));
class Solution{
public:
    int minDistance(string word1, string word2){
        int m = word1.size();
        int n = word2.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <=m; i++){
            for(int j = 1; j <= n; j++){
                if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] =min(min(dp[i-1][j-1],dp[i][j-1]), dp[i-1][j]) + 1;
            }
        }
        return dp[m][n];
    }
};

int main()
{
    string word1 = "horse";
    string word2 = "owe";
    Solution S;
    int res = S.minDistance(word1, word2);
    cout << res << endl;
    return 0;
}