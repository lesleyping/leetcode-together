# Problem
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
# Analyze

从左向右思路
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k = 0;
        for(int i = 0; i < nums.size(); i++){
            if(i > k)return false;
            k = max(k, nums[i]+i);
        }
        return true;
    }
};


从右向左

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k = 1;
        for(int i = nums.size()-2; i >= 0; i--){
            if(nums[i] >= k){
                k = 1;
            }
            else k++;
            if(i==0){
                if(nums[i] < k) return false;
            }
        }
        return true;
    }
};


动态规划

class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<bool> dp(nums.size(), false);
        if(nums.empty() || nums.size() == 1)return true;
        if(nums[0] == 0) dp[0] = false;
        else dp[0] = true;
        for(int i = 1; i < nums.size(); i++){
            for(int j = 0; j < i; j++){
                if(nums[j]+j >= i && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.size() - 1];
    }
};
