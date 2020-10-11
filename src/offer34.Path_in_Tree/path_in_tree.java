import java.util.ArrayList;
/**
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
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        helper(new ArrayList<>(), root, target);
        return res;
    }
    private void helper(ArrayList<Integer> list, TreeNode root, int target){
        if(root == null){
            return ;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }else{
            helper(list, root.left, target);
            helper(list, root.right, target);
        }
        list.remove(list.size()-1);
    }
}