# Problem
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

# SolutionOne
首先将两个有序数组合并，然后寻找其中位数。
但时间复杂度达到了O（m+n）

# SolutionTwo
在统计中，中位数被用来将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集重的元素。
### 定义“cut”
通过切一刀，将有序数组分为左右两个部分，切的那一刀被称为割“cut”，cut的左右两边有两个元素，分别是左边的最大值和右边的最小值，记为
LMax = Max(LeftPart), RMin = Min(RightPart)
### 两个数组进行“cut”
对于两个数组来说，设定LMaxi为第i个数组cut后的左元素，RMini为第i个数组cut后的右元素

![](https://github.com/npujcong/leetcode-together/blob/master/src/4.Midian_Of_Two_Sorted_Arrays/imgs/1.png)

通过cut的定义可以知道，LMax1<=RMin1,LMax2<=RMin2，

然而，假设LMax1<=RMin2,LMax2<=RMin1时，如下图

![](https://github.com/npujcong/leetcode-together/blob/master/src/4.Midian_Of_Two_Sorted_Arrays/imgs/2.png)

这样的话左半边全部小于右半边，如果左边的元素个数相加刚好等于k，那么第k个元素就是Max(LMax1,LMax2)
若 LMax1 > RMin2，则说明数组1的左边元素太大（多），此时减小c1，c2=k-c1相应增大；
若 LMax2 > RMin1，则说明数组2的左边元素太大（多），此时减小c2，c1=k-c2相应增大。
### 解决两个数组之和的奇偶不固定问题
当数组为奇数和偶数时，中位数的计算方法不相同，为了合并两个数组后避免对新数组的奇偶性进行判定，我们将每个数组转换为奇数，那么两个数组之和必定为偶数，其中位数就为中间位置两边元素的平均值。
我们通过虚拟加入“#”将数组变为长度为（2*len+1）
如：1，3，5 -> #,1,#,3,#,5,#
1,2,3,4 -> #,1,#,2,#,3,#,4,#

转换回来的方法也很简单，将新的位置除以2可以得到原来的位置。
对于cut总有以下规律：LMaxi=(Ci-1)/2位置上的元素，RMini=Ci/2位置上的元素

最快的割(Cut)是使用二分法，

### 有2个数组，我们对哪个做二分呢？
根据之前的分析，我们知道了，只要C1或C2确定，另外一个也就确定了。这里，为了效率，我们肯定是选长度较短的做二分，假设为C1。

LMax1>RMin2，把C1减小，C2增大。—> C1向左二分

LMax2>RMin1，把C1增大，C2减小。—> C1向右二分

### 考虑边界问题（如果C1或C2已经到头了怎么办？）

这种情况出现在：如果有个数组完全小于或大于中值。假定n<m, 可能有4种情况：

C1 = 0 —— 数组1整体都在右边了，所以都比中值大，中值在数组2中，简单的说就是数组1割后的左边是空了，所以我们可以假定LMax1 = INT_MIN

C1 =2n —— 数组1整体都在左边了，所以都比中值小，中值在数组2中 ，简单的说就是数组1割后的右边是空了，所以我们可以假定RMin1= INT_MAX，来保证LMax2<RMin1恒成立

C2 = 0 —— 数组2整体在右边了，所以都比中值大，中值在数组1中 ，简单的说就是数组2割后的左边是空了，所以我们可以假定LMax2 = INT_MIN

C2 = 2m —— 数组2整体在左边了，所以都比中值小，中值在数组1中, 简单的说就是数组2割后的右边是空了，为了让LMax1 < RMin2 恒成立，我们可以假定RMin2 = INT_MAX
