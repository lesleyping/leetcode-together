# Problem
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

# Analyze
二分查找：
模板：
'''
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;


    while(...) {
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
'''
二分查找的技巧：不出现else，而是把所有else if写清楚
计算mid时的防溢出技巧：mid = left + (right-left)/2

一、寻找一个数（基本的二分搜索）
'''
int binarySearch(int[] mums, int target){
    int left = 0;
    Int right = mums.length - 1;
    While(left <= right){            //
        Int mid = (right - left)/2;
        If(mums[mid] == target)
            Return mid;
        Else if(mums[mid] < target)
            Left = mid + 1;
        Else if(nums[mid] > target)
            Right = mid - 1;
        }
    Return -1;
}
'''
细节：<=是因为初始化为闭区间，mid的取值+1/-1是因为mid在if中已经判断过了，在之后应该跳过。

二、寻找左侧边界的二分搜索
'''
int left_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0;
    int right = nums.length; // 注意
    
    while (left < right) { // 注意
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid; // 注意
        }
    }
    return left;
}
'''

细节：（1）使用开区间 因此用<
        （2）不存在的值 在结尾加这一段
‘’‘
while (left < right) {
    //...
}
// target 比所有数都大
if (left == nums.length) return -1;
// 类似之前算法的处理方式
return nums[left] == target ? left : -1;
’‘’

（3）为什么 left = mid + 1，right = mid ？和之前的算法不一样？

答：这个很好解释，因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)。
（4）. 为什么该算法能够搜索左侧边界？

答：关键在于对于 nums[mid] == target 这种情况的处理：
 if (nums[mid] == target)
        right = mid;

可见，找到 target 时不要立即返回，而是缩小「搜索区间」的上界 right，在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。

三、寻找右侧边界的二分查找
‘’‘
int right_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0, right = nums.length;
    
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            left = mid + 1; // 注意
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left - 1; // 注意
}
’‘’
1.关键点在于nums[mid] == target 时，不要立即返回，而是增大「搜索区间」的下界 left，使得区间不断向右收缩，达到锁定右侧边界的目的。
2 为什么最后返回 left - 1 而不像左侧边界的函数，返回 left？而且我觉得这里既然是搜索右侧边界，应该返回 right 才对。
答：首先，while 循环的终止条件是 left == right，所以 left 和 right 是一样的，你非要体现右侧的特点，返回 right - 1 好了。

至于为什么要减一，这是搜索右侧边界的一个特殊点，关键在这个条件判断：

if (nums[mid] == target) {
    left = mid + 1;
    // 这样想: mid = left - 1

因为我们对 left 的更新必须是 left = mid + 1，就是说 while 循环结束时，nums[left] 一定不等于 target 了，而 nums[left-1] 可能是 target。更多精彩文章欢迎关注我的众公号 labuladong。

至于为什么 left 的更新必须是 left = mid + 1，同左侧边界搜索，就不再赘述。

3. 为什么没有返回−1 的操作？如果 nums 中不存在 target 这个值，怎么办？

答：类似之前的左侧边界搜索，因为 while 的终止条件是 left == right，就是说 left 的取值范围是 [0, nums.length]，所以可以添加两行代码，正确地返回-1
while (left < right) {
    // ...
}
if (left == 0) return -1;
return nums[left-1] == target ? (left-1) : -1;













