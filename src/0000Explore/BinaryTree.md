# 二叉树
## 树的遍历
### 1.二叉树的前序遍历
- Solution1
  - 递归
- Solution2
  - 迭代
    - 弹出栈顶元素
    - 输出该元素
    - 右节点压栈
    - 左节点压栈

### 2.二叉树的中序遍历
- Sllution1
  - 递归
- Solution2
  - 迭代
    - 先到达树的最左节点
    - 再依次处理


### 3.二叉树的后序遍历
- Sllution1
  - 递归
- Solution2
再来看后序遍历，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了

### 4.二叉树的层序遍历
- Solution1
  - 迭代
- Solution2
  - 递归



## 递归

### 5.二叉树的最大深度
- 自下向上，递归
- BFS 队列
- DFS 栈同时保存深度信息

### 6.对称二叉树
终止条件：

left 和 right 不等，或者 left 和 right 都为空\
递归的比较 left.left 和 right.right，递归比较 left.right 和 right.left

- 递归
- 队列

### 7.路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。
- 递归
- DFS（利用两个栈存储信息，中序遍历的思路）
- DFS(一个栈，但需要换为后序遍历的思路，因为中序遍历会提前弹出中间节点，然后再访问右节点，路线不完整)
- BFS（两个队列，层序遍历）

## 总结
### 8.从中序与后序遍历序列构造二叉树
- 后序最后一位来定位中序的左右分界
- 根据中序左右长度递归

### 9.从前序与中序遍历序列构造二叉树
- 前序第一位来定位中序的左右分界
- 根据中序左右长度递归

[__前序 + 后序__]

分析：前序，第二位即为左子树的根节点

根据这个根节点，在后序中该节点之前的一段均为左子树范围！！！
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }
    private TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int index = postStart;
        while(pre[preStart + 1] != post[index]){
            index++;
        }
        root.left = helper(pre, post, 
                preStart + 1, preStart + 1 + index - postStart,
                postStart, index);
        root.right = helper(pre, post,
                preStart + 1 + index - postStart + 1, preEnd,
                index + 1, postEnd - 1);
        return root;
    }
}
```

### 10.填充每个节点的下一个右侧节点指针
- BFS,不记录pre结点，利用linkedLis的get方法连接
- 拉链法，递归
- 迭代法，一层一层遍历

### 11.填充每个节点的下一个右侧节点指针 II
- BFS，记录pre结点
- dummy新节点，串起下一行的所有节点

### 12.填充每个节点的下一个右侧节点指针 II
- 剑指offer最后一题，由于只是二叉树，所以递归root，根绝left和right的情况进行接下来的递归


### 13.二叉树的序列化与反序列化
#### Solution1
- 剑指offer思路，先序遍历
- 重建本身需要前序+中序至少两种排序结果，但如果给前序加上null的记录，就可以进行重建

#### Solution2
- 层次遍历
