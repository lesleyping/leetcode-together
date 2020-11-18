//1
import java.util.*;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            res.add(cur.val);
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
        return res;
    }
}
//2-BFS     好像不对！！！！
// [0,2,4,1,null,3,-1,5,1,null,6,null,8]
import java.util.*;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        bfs(res, root);
        return res;
    }
    private void bfs(ArrayList<Integer> res, TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left != null){
            res.add(root.left.val);
        }
        if(root.right != null){
            res.add(root.right.val);
        }
        bfs(res, root.left);
        bfs(res, root.right);
    }
}
