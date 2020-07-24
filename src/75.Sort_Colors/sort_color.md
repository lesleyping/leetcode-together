# Problem
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

# Analyze
看到题懵了，这不是我不想仔细看的“三向切分”快排吗？
常数空间肯定想到快排。
这里用三个值来代表三个区间，要注意区间端点的划分！！！
[lo, lt-1]  < v
[lt, gt] == v
[gt+1, hi] > v

