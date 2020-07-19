# Problem
```
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
# Analyze
## Solution
固定一位，与另一位相加，然后遍历是否存在前面两数之和的相反数。这样时间复杂度为O(n^3)
通过双指针优化效率
在过程中要注意对重复情况的筛选
