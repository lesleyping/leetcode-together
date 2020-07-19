# Tag
string

# Problem
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

* Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

* Example 2:

Input: "cbbd" 
Output: "bb"

# Analyze
## Defination
子串：小于等于原字符串长度,由原字符串中任意个连续字符组成的子序列

回文：关于中间字符对称的文法，即“aba”(单核)、“cabbac”(双核)等

最长回文子串：1.寻找回文子串；2.该子串是回文子串中长度最长的。
## Solutionone
找到两个连续相同的字母，即s[i]==s[i+1]时，判断s[i-1] s[i+2]是否相等，依次判断下去，最后记住符合条件的两个下标值。