/*
105. 从前序与中序遍历序列构造二叉树
*/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return cur;
        }
        int idx;
        for (idx = inStart; idx <= inEnd; idx++) {
            if (inorder[idx] == preorder[preStart]) {
                break;
            }
        }
        cur.left = build(preorder, preStart+1, preStart+1+(idx-1-inStart), inorder, inStart, idx-1);
        cur.right = build(preorder, preStart+1+(idx-1-inStart)+1, preEnd, inorder, idx+1, inEnd);
        return cur;
    }
}

