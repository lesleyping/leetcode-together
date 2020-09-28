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
    int k1 = 0;
    TreeNode target = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        k1 = k;
        dfs(pRoot);
        return target;
    }
    void dfs(TreeNode root){
        if(root == null || k1 <= 0){
            return ;
        }
        dfs(root.left);
        k1--;
        if(k1 == 0){
            target = root;
            return;
        }
        dfs(root.right);
    }
}