# Problem
给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证右部分是否有序
例如，arr = [1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9]，调整之后arr=[1, 2, 3, 4, 5, 6, 7, 8, 9, .....]。

[要求]

时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
# Anylyze
- 快排的思路

[0,l]该范围内，满足题目要求的递增且不重复

[l+1, i]该范围内，满足递增但不满足不重复

i不断向后遍历，直至到达数组终点