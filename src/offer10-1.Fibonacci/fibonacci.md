## Problem
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
n<=39

## Anylyze
### Solution1
时间复杂度：O(n)

### Solution2
时间复杂度：O(lgn)
[fn, fn-1]       [1 1] ^n-1
[fn-1, fn-1]   = [1 0]