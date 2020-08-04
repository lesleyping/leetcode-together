# Problem
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
```
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
```
```
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
```

# Analyze
注意理解最长有效括号的意义
(())是一个有效括号序列

## Solution
先用栈给出暴力解法，即每一组长度为偶数的序列要被送入进行检查，但此方法时间复杂度为O(n^3)
## Solution2
动态规划问题
每一个位置生成当前的有效括号长度值。
![1](https://github.com/npujcong/leetcode-together/blob/master/src/32.Longest_Valid_Parentheses-DP/img/1.png)

## Solution3
栈的方法不太能理解..
之后再好好思考一下

## Solution4
左右扫描两边，思路大概可以理解。