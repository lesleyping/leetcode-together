## Problem
请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

## Anylyze
### Solution1-递归
- 1.只要pRoot.left和pRoot.right是否对称即可
- 2.左右节点的值相等且对称子树left.left， right.right ;left.rigth,right.left也对称
### Solution2-DFS
DFS使用stack来保存成对的节点
- 1.出栈的时候也是成对成对的 ，
    - 1.若都为空，继续；（__continue__很重要，不能直接返回）
    - 2.一个为空，返回false;
    - 3.不为空，比较当前值，值不等，返回false；
- 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left

### Solution3-BFS
与栈相似，使用队列保存成对节点
