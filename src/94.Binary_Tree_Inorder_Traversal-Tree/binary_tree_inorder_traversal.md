# Problem
Given a binary tree, return the inorder traversal of its nodes' values.
‘’‘
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
’‘’
Follow up: Recursive solution is trivial, could you do it iteratively?

# Analyze
前序、中序、后序是指，对根节点记录的顺序，

前序：根节点+左子树+右子树
中序：左子树+根节点+右子树
后序：左子树+右子树+根节点

## Solution
Solution 递归

https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/die-dai-fa-by-jason-2/

Solution1 迭代：使用栈和模拟指针，改变入栈顺序
#include<stack>
class Solution{
public:
    vector<int> inorderTraversal(TreeNode* root){
        vector<int> v;
        TreeNode *rt = root;
        stack<TreeNode*> S;
        while(rt || S.size()){
            while(rt){
                S.push(rt);
                rt = rt->left;
            }
            rt = S.top();S.pop();
            v.push_back(rt->val);
            rt = rt->right;
        }
        return v;
    }
};
