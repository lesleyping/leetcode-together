/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetricalCore(pRoot, pRoot);
    }
    boolean isSymmetricalCore(TreeNode p1, TreeNode p2){
        if(p1 == null && p1 == null){
            return true;
        }
        if(p1 == null || p2 == null){
            return false;
        }
        if(p1.val != p2.val){
            return false;
        }
        return isSymmetricalCore(p1.left, p2.right) && isSymmetricalCore(p1.right, p2.left);
    }
}

