#include<iostream>
#include<vector>
using namespace std;

class Solution{
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid){
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        if(obstacleGrid[0][0] == 1) return 0;

        long long  dp[m][n];
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) dp[i][0] = 1;
            else dp[i][0] = 0;   //important!!!
        }
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 0 && dp[0][i-1] == 1) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i-1][j] + dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
};


int main()
{
    vector<vector<int> > obstacleGrid {{0,0,0},{0,1,0},{0,0,0}} ;
    // for(int i = 0; i<obstaclrGrid.size();i++){
    //     for(int j = 0; j<obstaclrGrid[i].size();j++){
    //         cout << obstaclrGrid[i][j] <<endl;
    //     }
    // }
    Solution S;
    int res = S.uniquePathsWithObstacles(obstacleGrid);
    cout << res << endl;
    return 0;
}