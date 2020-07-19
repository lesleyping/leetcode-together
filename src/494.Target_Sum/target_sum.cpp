#include<iostream>
using namespace std;

class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        if(nums.size() == 0) return 0;
        int sum = 0;
        for(auto item : nums){
            sum += item;
        }
        if(sum < S || (S + sum) % 2 == 1) return 0;
        int p = (S + sum) / 2;
        vector<int> dp(p+1, 0);
        dp[0] = 1;
        for (auto num : nums){
            for(int i = p; i >= num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[p];
    }
};

int main(){
    int target = 3;
    vector<int> nums = [1,1,1,1,1];
    int res = findTargetSumWays(nums, target);
    cout << res << endl;
}