# Problem
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

# Analyze
## Solution
一遍循环，每次更新以当前位置结尾的最大子序列的和；
思路：
如果之前的和小于0，那么就对之后序列没有正向贡献。

## Solution2 
### 需要好好理解 但本题动态规划结果已经足够
题目要求尝试分治算法解决这个问题
时间复杂度O(nlogn)
思路：
取数组中心点为中心，最大子序列要么在左边，要么在右边，要么跨中心。
跨中心时，在分成中心点左侧和右侧的最大子序和问题。

## 思路
贪心算法：
从左向右扫描，一个一个加起来，如果sum小于0，那么重新开始寻找自序串。