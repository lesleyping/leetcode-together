## problem
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

## Anylyze
### solution1 利用栈的STL+int变量

- int型变量保存最小值

- 同时需要保存上一个最小值，因此，压入当前最小值之前压入上一个最小值


### solution2 不使用STL

- delete很重要

