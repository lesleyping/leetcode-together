/*
• 思想
    • 穷举
    • 空间换时间
一、入门问题
509. 斐波那契数
了解「自顶向下」记忆化递归与「自底向上」递推两种动态规划的方式。
• 1 递归
时间 O(2^N)
空间 O(N)
*/
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
//• 2 自顶向下记忆化递归
class Solution {
    Integer[] dp;
    public int fib(int n) {
        dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = 1;
        memory(n);
        return dp[n];
    }
    private int memory(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = memory(n-1) + memory(n-2);
        return dp[n];
    }
}
/*
• 3 备忘录【自底向上递推】
时间 O(N)
空间 O(N)
*/
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
}
/*
• 4 只记录前两项
时间 O(N)
空间 O(1)
*/
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            prev2 += prev1;
            prev1 = prev2 - prev1;
        }
        return prev2;
    }
}
/*
二、重复子问题
这部分需要用到「分步计数乘法原理」、「分类计数加法原理」。
70. 爬楼梯
• 1 递归
时间：O(2^n)
空间：O(n)
*/
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
//• 2 自底向上递推
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
// • 3 自顶向下记忆集优化
class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n+1];
        dp[0] = 1;
        dp[1] = 1;
        memory(n);
        return dp[n];
    }
    private int memory(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = memory(n-1) + memory(n-2);
        return dp[n];
    }
}
// • 4 两个字段来保存
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            prev2 += prev1;
            prev1 = prev2 - prev1;
        }
        return prev2;
    }
}
/*
[*]91. 解码方法
相当于爬楼梯，一次可以走一或两层
举例：
2 0 : 当前为0，只能走两步，dp[i] = dp[i-2]
3 3 : 当前为3，这两个数字不满足条件，只能一步一步走，dp[i] = dp[i-1]
2 3 : 当前为3，这两个数字满足条件，可走一步或两步，dp[i] = dp[i-1] + dp[i-2]
*/
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        } 
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i+1] = dp[i];
            }
            if (i > 0) {
                int tmp = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
                if (tmp >= 10 && tmp <= 26) {
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[len];
    }
}
/*
剑指 Offer 46. 把数字翻译成字符串
• 递归【回溯？】
*/
class Solution {
    public int translateNum(int num) {
        int res = 0;
        res = dfs(String.valueOf(num), 0);
        return res;
    }
    private int dfs(String num, int idx) {
        if (idx == num.length()) {
            return 1;
        }
        if (num.charAt(idx) != '0' && idx + 1 < num.length() 
            && Integer.valueOf(num.substring(idx, idx+2)) <= 25){
                return dfs(num, idx+1) + dfs(num, idx+2);
        } else {
            return dfs(num, idx+1);
        }
    }
}
/*
• 动态规划
2 7 : 不满足，只能走一步，dp[i] = dp[i-1]
2 3 : 满足，走两步，dp[i] = dp[i-1] + dp[i-2]
0 3 : 不满足，走一步，dp[i] = dp[i-1]
*/
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i+1] = dp[i];
            if (i > 0) {
                int tmp = Integer.valueOf(s.substring(i-1, i+1));
                if (tmp >= 10 && tmp <= 25) {
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[len];
    }
}
/*
三、最优子结构
279. 完全平方数
• dfs 超时解法
*/
class Solution {
    public int numSquares(int n) {
        int res = dfs(n);
        return res;
    }
    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, dfs(n - i * i) + 1);
        }
        return count;
    }
}
// • 优化 hashmap
class Solution {
    HashMap<Integer, Integer> map;
    public int numSquares(int n) {
        map = new HashMap<>();
        int res = dfs(n);
        return res;
    }
    private int dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, dfs(n - i * i) + 1);
        }
        map.put(n, count);
        return count;
    }
}
// • dp
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                count = Math.min(count, dp[i - j * j] + 1);
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
// [*]322. 零钱兑换
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] != amount+1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
        
    }
}
/*
343. 整数拆分
四、无后效性
198. 打家劫舍
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
/*
121. 买卖股票的最佳时机
• 暴力
*/
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(prices[j] - prices[i], res);
            }
        }
        return res;
    }
}
/*
• dp
122. 买卖股票的最佳时机 II
五、最大子段和
53. 最大子序和
六、最长上升子序列
[**]300. 最长递增子序列
• dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
/*
• 二分 先放着吧😭
第 14 章 动态规划（下）
一、背包问题
416. 分割等和子集
• 背包问题，不太会啊
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum % 2) == 1) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target+1];
        // 0 行
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 从 第 1 行开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
/*
O(NC)
O(NC)
• dp[0][0] = true
只要相应的改变状态转移方程即可
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum % 2) == 1) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target+1];
        // 0 行
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 从 第 1 行开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
// • 【简单来说，一维逆序，是0-1背包，一维不逆序，是完全背包。】
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            if (dp[target] == true) {
                return true;
            }
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}