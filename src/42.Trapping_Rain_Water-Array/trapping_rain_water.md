# Problem
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

# Analyze
动态规划和双指针思路

1. 普通算法
遍历，时间复杂度为n的平方
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() == 0) return 0;
        int ans = 0;
        for(int i = 1; i < height.size()-1; i++){
            int maxleft = 0;
            int maxright = 0;
            for(int j = 0; j <= i; j++){
                if(height[j] > maxleft) maxleft = height[j];
            }


            for(int j = i; j <= height.size()-1; j++){
                if(height[j] > maxright) maxright = height[j];
            }
            ans = ans + min(maxleft, maxright) - height[i];


        }
        return ans;
    }
};
2. 备忘录优化
将所有最大高度记录下来
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if(n == 0) return 0;
        int ans = 0;
        vector<int> leftmax(n, 0);
        vector<int> rightmax(n, 0);
        leftmax[0] = height[0];
        rightmax[n-1] = height[n-1];
        
        for(int i = 1; i < n; i++){
            leftmax[i] = max(leftmax[i-1], height[i]);
        }
        
        for(int i = n-2; i>=0 ; i--){
            rightmax[i] = max(rightmax[i+1], height[i]);
        }


        for(int i = 1 ; i < n-1; i++){
            ans = ans + min(leftmax[i], rightmax[i]) - height[i];
        }
        return ans;
    }
};
写的时候注意一下初始化！！！

    3. 双指针解法
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if(n == 0) return 0;
        int ans = 0;
        int left = 0;
        int right = n-1;
        int lmax = height[0];
        int rmax = height[n-1];


        while(left <= right){
            lmax = max(lmax, height[left]);
            rmax = max(rmax, height[right]);
            if(lmax < rmax){
                ans += lmax - height[left];
                left++;
            }
            else{
                ans += rmax - height[right];
                right--;
            }
        }
        return ans;
    }
};
