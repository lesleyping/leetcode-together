//1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        
        return isValidBST(root.right);
    }
}

//2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        this.prePush(root);
    }
    
    private void prePush(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right != null){
            this.prePush(cur.right);
        }
        return cur.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 //3-1 递归
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val < val){
            return searchBST(root.right, val);
        } else if(root.val > val){
            return searchBST(root.left, val);
        } else{
            return root;
        }
    }
}

//3-2 迭代
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root;
            } else if(root.val < val){
                root = root.right;
            } else{
                root = root.left;
            }
        }
        return null;
    }
}

//4
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null){
            return node;
        }
        TreeNode cur = root;
        while(cur != null){
            if(val < cur.val){
                if(cur.left == null){
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else if(val > cur.val){
                if(cur.right == null){
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        
        return root;
    }
}

//
