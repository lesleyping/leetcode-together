## Problem
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

## Anylyze
### Solution1
- 画图
画出四种情况，分别是走一步、两步、三步和四步
- 注意边界条件（后两种要顾及x和y的情况）
- 循环继续下去的条件是：2 * startx < cols, 2 * starty < rows

### Solution2
设置边界，不断循环打印