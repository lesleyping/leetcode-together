## Problem
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0

## Anylyze
### Solution1
细节：
- 当底数为0且指数<0时\
会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
- 判断底数是否等于0\
由于base为double型，不能直接用==判断
### Solution2(与斐波那契数列相似的优化方式)
- 优化求幂函数\
当n为偶数，a^n =（a^n/2）*（a^n/2）
当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
时间复杂度O(logn)
### 书中优化方法
- 右移代替 /2
- 与 运算代替 取余
