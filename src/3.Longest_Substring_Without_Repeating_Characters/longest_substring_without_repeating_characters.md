# Problem
Given a string, find the length of the longest substring without repeating characters.
## Solution one
遍历整个string，寻找最长的字符串并记录长度，用3个for循环。
## Solution two
滑动窗口思路
https://pic.leetcode-cn.com/5e6a469831d44b21d3937442d99f36f8d978c153900ee36c1c6d7443c41b1d95
原始字符串s如图所示

从左侧开始遍历s，以i来标记窗口左侧，