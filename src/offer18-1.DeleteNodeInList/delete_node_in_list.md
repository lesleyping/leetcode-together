## Problem
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动
'''
示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
'''
'''
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
'''

这道题与《剑指offer》有一些不同：

本题中，输入的类型为：head: ListNode, val: int，即 val 的类型是整形；
在《剑指offer》中，默认输入为 head: ListNode, val: ListNode，即 val 的类型是链表。


## Anylyze
### Solution1
采用O(n)复杂度的遍历方法

### Solution2
复杂度：O(1)
将要删除结点的下一节点的值覆盖要删除节点，变为删除下一节点；
- 注意：
删除的节点是不是尾结点（是则遍历）；
删除的节点是不是头节点且仅有头节点（是则返回空，头节点置空）；
