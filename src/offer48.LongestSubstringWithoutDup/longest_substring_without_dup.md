# Problem
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

# Anylyze
按照剑指offer上写了半天，发现leetcode中没有限制只出现字母....\
那就先把字母的贴着吧。\
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] position = new int[26];
        for(int i = 0; i < 26; i++){
            position[i] = -1;
        }
        int curLen = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            int preIndex =  position[s.charAt(i) - 'a'];
            
            if(preIndex < 0 || i - preIndex > curLen){
                curLen++;
            }else{
                if(curLen > maxLen){
                    maxLen = curLen;
                }
                curLen = i - preIndex;
            }
            position[s.charAt(i) - 'a'] = i;
        }
        if(curLen > maxLen){
            maxLen = curLen;
        }
        return maxLen;
    }
}
```

## Solution1
方法一：动态规划 + 哈希表
哈希表统计： 遍历字符串 s 时，使用哈希表（记为 dic ）统计 各字符最后一次出现的索引位置 。
左边界 i 获取方式： 遍历到 s[j] 时，可通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i。
复杂度分析：
时间复杂度 O(N) ： 其中 NN 为字符串长度，动态规划需遍历计算 dp 列表。
空间复杂度 O(1) ： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表 dic最多使用 O(128) = O(1) 大小的额外空间。

## Solution2
方法三：双指针 + 哈希表
本质上与方法一类似，不同点在于左边界 i 的定义。

哈希表 dic 统计： 指针 j 遍历字符 s ，哈希表统计字符 s[j]最后一次出现的索引 。
更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大。
i = \max(dic[s[j]], i)

更新结果 res ： 取上轮 res和本轮双指针区间 [i + 1,j] 的宽度（即 j - i ）中的最大值。
res = \max(res, j - i)

复杂度分析：
时间复杂度 O(N) ： 其中 N 为字符串长度，动态规划需遍历计算 dp 列表。
空间复杂度 O(1) ： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表dic 最多使用 O(128) = O(1)大小的额外空间。
