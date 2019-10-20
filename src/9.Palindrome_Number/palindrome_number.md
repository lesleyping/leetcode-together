# Problem
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

# Analyze
## Solution
将整数按位存在vector中，然后从两端比较两个数字是否相同。
## Solution2
为了避免反转整数后存在溢出问题，选择仅反转后半段的数字，再与前半段进行比较。
此时，要注意以0结尾的数字，当0为结尾时，若为回文字数，第一位也为0，只有数字0做得到，因此当这个数不是0时返回false。