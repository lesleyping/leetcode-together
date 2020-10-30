import java.util.ArrayList;
import java.util.*;
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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(pRoot);
        int cur = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            if(cur == 0){
                while(!stack1.isEmpty()){
                    TreeNode tmp = stack1.pop();
                    arr.add(tmp.val);
                    if(tmp.left != null){
                        stack2.push(tmp.left);
                    }
                    if(tmp.right != null){
                        stack2.push(tmp.right);
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    TreeNode tmp = stack2.pop();
                    arr.add(tmp.val);
                    if(tmp.right != null){
                        stack1.push(tmp.right);
                    }
                    if(tmp.left != null){
                        stack1.push(tmp.left);
                    }
                }
            }
            res.add(arr);
            cur = 1 - cur;
        }
        return res;
    }
}