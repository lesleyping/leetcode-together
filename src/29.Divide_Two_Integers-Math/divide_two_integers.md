# Problem
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
```
Input: dividend = 10, divisor = 3
Output: 3
```
```
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
```
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

# Analyze
## Solution
· 题目的根本在于（被除数）可以减去多少次（除数），暴力解题较为耗时，优化思路。
· 循环倍增（除数）知道再倍增就无法被（被除数）整除为止，记录除数增大的（倍数），然后将（被除数）减去目前的（除数），将除数恢复进入下一次循环，结果即为所有记录的倍数相加。
!!但题目说只能存32位，可能用long还有问题。需要再思考。