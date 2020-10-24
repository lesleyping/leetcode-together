public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left == -1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left,right);
    }
}
//-------second
//直接递归了
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }
        return true;
    }
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}