## Problem
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

## Anylyze
### Solution1-辅助栈
使用另一个辅助栈，每次压入当前最小的值

### Solution2-STL
- 不使用另外的辅助栈
- int型变量保存最小值
- 同时需要保存上一个最小值，因此，压入当前最小值之前压入上一个最小值

### Solution3-不使用STL
- 用链表实现栈
- delete很重要