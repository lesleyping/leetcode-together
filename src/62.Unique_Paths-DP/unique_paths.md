# Problem
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
```
Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
```
```
Example 2:

Input: m = 7, n = 3
Output: 28
```

# Analyze
## Solution
排列组合方法
```
Class Sulotion{
    
    public int uniquePaths(int m, int n) {
        double value = 1;
        for (int i = 1; i <= n - 1; i++) {
            value *= ((double) (m + i - 1) / (double) i);
        }
        return (int) Math.round(value);
    }
```
深搜
```
class Solution {
    public int uniquePaths(int m, int n) {
        return repeat(m, n, 0, 0);
    }
    
    private int repeat(int m, int n, int right, int down){
        if (m == right + 1 && n == down + 1)
            return 1;
        int count = 0;
        if (right+1 < m)
            count += repeat(m, n, right+1, down);
        if (down + 1 < n)
            count +=repeat(m, n, right, down+1);
        return count;
    }

```
动态规划
```
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1]*n] + [[1]+[0] * (n-1) for _ in range(m-1)]
        #print(dp)
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]

```
