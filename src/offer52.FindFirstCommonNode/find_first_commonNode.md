# Problem
输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

# Anylyze
## Solution1
两个指针分别指向两个链表的起点\
当一个到达尾部时，将其置于另一个的起点，继续遍历
## Solution2
遍历，记录长度，手动消除长度差