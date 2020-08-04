# Problem
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"


# Analyze
## Solution
· 康托展开
给定一个序列，怎么确定它的排名呢？

就用到了这样一个公式X=a[n]*(n-1)!+a[n-1]*(n-2)!+a[n-2]*(n-3)!+...+a[1]*0!

其中a[n]表示当前数是数列中未出现的数中第几小的【注意从0开始计数】

· 康托逆展开
