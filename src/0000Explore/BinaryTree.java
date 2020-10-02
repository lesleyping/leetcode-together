//1-1
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
//1-2
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp != null){
                res.add(tmp.val);
            } else{
                continue;
            }
            stack.push(tmp.right);
            stack.push(tmp.left);
        }
        return res;
    }
}
//2-1
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}
//2-2
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode q = root;
        while(q != null || !stack.isEmpty()){
            if(q != null){
                stack.push(q);
                q = q.left;
            }else{
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                q = tmp.right;
            }
        }
        return res;
    }
}
//3-1
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return ;
        }
        dfs(res, root.left);
        dfs(res, root.right);
        res.add(root.val);
    }
}
//3-2
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp != null){
                res.add(tmp.val);
                stack.push(tmp.left);
                stack.push(tmp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
//4-1
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> arr = new ArrayList<>();
            while(len > 0){
                TreeNode tmp = queue.poll();
                arr.add(tmp.val);
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                len--;
            }
            res.add(arr);
        }
        return res;
    }
}
//4-2
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(res, root, 0);
        return res;
    }
    private void bfs(List<List<Integer>> res, TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(res.size() == depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        bfs(res, root.left, depth+1);
        bfs(res, root.right, depth+1);
    }
}
//5-1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //自下向上
 class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//5-2
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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if(root == null){
            return 0;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            depth++;
            int len = queue.size();
            while(len > 0){
                TreeNode tmp = queue.poll();
                len--;
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        return depth;
    }
}
//5-3
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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> levelStack = new LinkedList<>();
        nodeStack.push(root);
        levelStack.push(1);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int level = levelStack.pop();
            depth = Math.max(depth,level);
            if(node.left != null){
                nodeStack.push(node.left);
                levelStack.push(level + 1);
            }
            if(node.right != null){
                nodeStack.push(node.right);
                levelStack.push(level + 1);
            }
        }
        return depth;
    }
}
