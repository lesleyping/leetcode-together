//非递归
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
import java.util.*;
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode head = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                if(pre != null){
                    pre.right = cur;
                    cur.left = pre;
                }else{
                    head = cur;
                }
                pre = cur;
                cur = cur.right;
            }
        }
       return head;
    }
}
//递归
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
import java.util.*;
public class Solution {
    TreeNode head, pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        dfs(pRootOfTree);
        return head;
    }
    private void dfs(TreeNode cur){
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(pre == null){
            head = cur;
        }else{
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}