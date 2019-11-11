# Problem
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
```
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```
```
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
```
```
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```
```
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
```
```
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
```
# Analyze
## Solution1
动态规划四要素：
（一）状态
f[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配

（二）转移方程
·如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “？”
f[i][j] = f[i - 1][j - 1]
·如果s2的第 j 个字符为 *
 ··若s2的第 j 个字符匹配空串, f[i][j] = f[i][j - 1]
 ··若s2的第 j 个字符匹配s1的第 i 个字符, f[i][j] = f[i - 1][j]
    这里注意不是 f[i - 1][j - 1]， 举个例子就明白了 (abc, a*) f[3][2] = f[2][2]

（三）初始化
f[0][i] = f[0][i - 1] && s2[i] == *
即s1的前0个字符和s2的前i个字符能否匹配

（四）结果
f[m][n]

