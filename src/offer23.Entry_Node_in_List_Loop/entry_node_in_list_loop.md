## Problem
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

## Anylyze
问题分解：
- 判断是否有环（快慢指针，一个走一步，一个走两步，是否相遇）
- 得到环的节点数（相遇后遍历一遍，得到n）
- 找出环的入口（快慢指针，从头开始，快指针先走n，然后一起走，相遇时快比慢多走一圈，两者都在入口）