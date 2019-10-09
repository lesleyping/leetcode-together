# Problem
Given a string, find the length of the longest substring without repeating characters.
## Solution one
遍历整个string，寻找最长的字符串并记录长度，用3个for循环。
## Solution two
滑动窗口思路
！[1](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/1.jpg)
原始字符串s如图所示

从左侧开始遍历s，以i来标记窗口左侧，