/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    private TreeNode helper(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int index = inStart;
        while(pre[preStart] != in[index]){
            index++;
        }
        root.left = helper(pre, in, preStart+1, preStart + 1 + index-1-inStart, inStart, index-1);
        root.right = helper(pre, in, preStart + 1 + index-1-inStart + 1, preEnd, index+1, inEnd);
        return root;
    }
}