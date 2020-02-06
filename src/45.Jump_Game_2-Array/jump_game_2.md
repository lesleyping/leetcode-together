# Problem
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.

# Analyze
动态规划的方法，会超时，但可以记录一下
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float("inf")] * n
        dp[0] = 0
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[j] >= i - j:
                    dp[i] = min(dp[i], dp[j] + 1)
        #print(dp)
        return dp[-1]



贪心算法，找到该节点可以到达的范围内，最大数字。

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) return 0;
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for(int i = 0; i < n-1; i++){
            maxPosition = max(maxPosition, nums[i] + i);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }


        return steps;
    }
};

