//1
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
public class Solution {
    String Serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        String res = root.val + ",";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
  }
    TreeNode Deserialize(String str) {
        String[] arr = str.split(",");
        Queue<String> q = new LinkedList<>();
        for(String s : arr){
            q.offer(s);
        }
        return helper(q);
  }
    TreeNode helper(Queue<String> q){
        String str = q.poll();
        if("null".equals(str)){
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(str));
        cur.left = helper(q);
        cur.right = helper(q);
        return cur;
    }
}
//2
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
public class Solution {
    String Serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuilder strb = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur != null){
                strb.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            }else{
                strb.append("null,");
            }
        }
        strb.deleteCharAt(strb.length()-1);
        strb.append("]");
        return strb.toString();
  }
    TreeNode Deserialize(String str) {
        if("[]".equals(str)){
            return null;
        }
        String[] arr = str.substring(1,str.length()-1).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i = 1; 
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(!"null".equals(arr[i])){
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.left);
            }
            i++;
            if(!"null".equals(arr[i])){
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
  }
}

//---------second
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
public class Solution {
    String Serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("null,");
            }else{
                sb.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
  }
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] arr = str.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);
        int idx = 1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if("null".equals(arr[idx])){
                cur.left = null;
            }else{
                cur.left = new TreeNode(Integer.parseInt(arr[idx]));
                q.offer(cur.left);
            }
            idx++;
            if("null".equals(arr[idx])){
                cur.right = null;
            }else{
                cur.right = new TreeNode(Integer.parseInt(arr[idx]));
                q.offer(cur.right);
            }
            idx++;
        }
        return head;
  }
}