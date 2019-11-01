# Problem
```
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
```
# Analyze
## Solution
首先想到的是两两求解，动态更新最大值即可。但这样的解法时间复杂度为O(n^2)

我们可以从长度为n开始计算矩形面积，然后不断减小边长。当我们计算n的面积时，假如左侧的线段高度比右侧低，那么我们通过左移右指针是没有意义的。
即 最大面积 一定是当前面积或通过移动短的线段得到的。

## Solution2