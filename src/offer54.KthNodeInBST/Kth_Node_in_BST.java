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
//-------------second
//中序遍历
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
import java.util.*;
//中序遍历
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode q = pRoot;
        int cnt = 0;
        while(q != null || !stack.isEmpty()){
            if(q == null){
                TreeNode cur = stack.pop();
                cnt++;
                if(cnt == k){
                    return cur;
                }
                q = cur.right;
            }else{
                stack.push(q);
                q = q.left;
            }
        }
        return null;
    }


}