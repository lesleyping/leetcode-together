## Problem
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

## Analyze1 修改数组
题目中重点：所有数字在0到n-1范围内
思路：遍历，将数字通过交换移动到它应该在的位置，若待交换的位置与其相等，则出现重复。
- 需要注意的点：
数组的值传递方式（*）
返回值的赋值方式
true和false情况不要写反
不要在循环中赋值，容易引起混淆（例如题目思路中所述：m=numbers[i],i一直在变，最好不要这样给m赋值）
### 复杂度
时间：O(n)
空间：O(1)

## Anylyze2 不修改数组
二分查找的思路

### 复杂度
时间：O(nlg(n))
空间：O(1)