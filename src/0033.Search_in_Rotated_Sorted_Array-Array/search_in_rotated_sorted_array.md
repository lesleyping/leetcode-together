# Problem
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
```
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```
```
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

# Analyze
## Solution
时间复杂度要求为O(log n)，可以想到二分查找算法
判断[0,mid] 升序：nums[0] <= nums[mid]，当target < nums[0] || target > nums[mid] 时，向后归约；
判断[0,mid] 有旋转位：nums[0] > nums[mid]，当target < nums[0] && target > nums[mid] 时，向后归约；
其余情况，向前归约

## solution2
判断left，mid和right之间的关系
