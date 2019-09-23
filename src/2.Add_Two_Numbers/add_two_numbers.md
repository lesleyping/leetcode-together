# 2 add two numbers
### question
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### analyze
1.在自己处理过程中，对不等长的情况进行了补齐链表的操作，可参考其他做法，不对链表进行补充。
2.注意最后一位进行相加时，进位还需处理。