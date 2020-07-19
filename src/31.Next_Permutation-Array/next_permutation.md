# Problem
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

# Analyze
## Solution
连成一个数后，第一个大于它的数的排序即为所求。

![1](https://github.com/npujcong/leetcode-together/blob/master/src/31.Next_Permutation-Array/img/1.gif)

首先从右边找到第一对连续数字，满足a[i]>a[i-1]；（此时a[i-1]右侧为降序，是一个最大的排列）
想要创建比当前更大的排序，要将数字a[i-1]换为右侧区域中数字比他更大的，如a[j]；
最后，将a[i-1]右侧所有数字按升序排列即可
