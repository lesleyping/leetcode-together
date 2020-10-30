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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> sta = new LinkedList<>();
        sta.offer(pRoot);
        while(!sta.isEmpty()){
            int len = sta.size();
            ArrayList<Integer> arr = new ArrayList<>();
            while(len > 0){
                TreeNode tmp = sta.poll();
                arr.add(tmp.val);
                if(tmp.left != null){
                    sta.offer(tmp.left);
                }
                if(tmp.right != null){
                    sta.offer(tmp.right);
                }
                len--;
            }
            res.add(arr);
        }
        return res;
    }
    
}