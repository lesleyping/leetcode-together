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
//6-1
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode ll, TreeNode rr){
        if(ll == null && rr == null){
            return true;
        }
        if(ll == null || rr == null){
            return false;
        }
        if(ll.val != rr.val){
            return false;
        }
        return dfs(ll.left, rr.right) && dfs(ll.right, rr.left);
    }
}
//6-2
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode ll = queue.poll();
            TreeNode rr = queue.poll();
            if(ll == null && rr == null){
                continue;                      //!!
            }
            if(ll == null || rr == null){
                return false;
            }
            if(ll.val != rr.val){
                return false;
            }
            queue.offer(ll.left);
            queue.offer(rr.right);
            queue.offer(ll.right);
            queue.offer(rr.left);
        }
        return true;
    }
}
//7-1
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
//7-2
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
    public boolean hasPathSum(TreeNode root, int sum) {
        //DFS
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        TreeNode cur = root;
        int curSum = 0;
        while(cur != null || !nodeStack.isEmpty()){
            if(cur != null){
                nodeStack.push(cur);
                curSum += cur.val;
                sumStack.push(curSum);
                cur = cur.left;
            }else{
                TreeNode nodeTmp = nodeStack.pop();
                curSum = sumStack.pop();
                if(curSum == sum && nodeTmp.left == null && nodeTmp.right == null){
                    return true;
                }
                cur = nodeTmp.right;
            }
        }
        return false;
    }
}
//7-3
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
    public boolean hasPathSum(TreeNode root, int sum) {
        //DFS
        Deque<TreeNode> nodeStack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curSum = 0;
        while(cur != null || !nodeStack.isEmpty()){
            if(cur != null){
                nodeStack.push(cur);
                curSum += cur.val;
                cur = cur.left;
            }else{
                cur = nodeStack.peek();
                if(curSum == sum && cur.left == null && cur.right == null){
                    return true;
                }
                // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
                if(cur.right == null || pre == cur.right){
                    TreeNode tmp = nodeStack.pop();
                    curSum -= tmp.val;
                    pre = tmp;
                    cur = null;
                }else{
                    // 右节点还没有访问过就先访问右节点
                    cur = cur.right;
                }
            }
        }
        return false;
    }
}
//7-4
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while(!nodeQueue.isEmpty()){
            int len = nodeQueue.size();
            while(len > 0){
                int curSum = sumQueue.poll();
                TreeNode cur = nodeQueue.poll();
                if(curSum == sum && cur.left == null && cur.right == null){
                    return true;
                }
                if(cur.left != null){
                    nodeQueue.offer(cur.left);
                    sumQueue.offer(curSum + cur.left.val);
                }
                if(cur.right != null){
                    nodeQueue.offer(cur.right);
                    sumQueue.offer(curSum + cur.right.val);
                }

                len--;
            }
        }
        return false;
    }
}
//8
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        if(inStart == inEnd){
            return root;
        }
        int index = inStart;
        while(postorder[postEnd] != inorder[index]){
            index++;
        }
        root.left = helper(inorder, postorder, 
            inStart, index - 1, postStart, postStart + (index - 1 - inStart));
        root.right = helper(inorder, postorder,
            index + 1, inEnd, postStart + index - inStart, postEnd - 1);
        return root;
    }
}
//9
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int index = inStart;
        while(preorder[preStart] != inorder[index]){
            index++;
        }
        root.left = helper(preorder, inorder, 
            preStart + 1, preStart + 1 + (index - 1 - inStart), inStart , index - 1);
        root.right = helper(preorder, inorder,
            preStart + 1 + (index - 1 - inStart) + 1, preEnd,
            index + 1, inEnd);
        return root;
    }
}
//10-1
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node tmp = queue.peek();
            int len = queue.size();
            for(int i = 1; i < len; i++){
                tmp.next = queue.get(i);
                tmp = tmp.next;
            }
            for(int i = 0; i < len; i++){
                tmp = queue.poll();
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        return root;
    }
}
//10-2
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
//10-3
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点
		//或所有叶子节点都出串联完后循环就退出了
        while(pre.left != null){
            Node cur = pre;
            //将tmp的左右节点都串联起来
				//注:外层循环已经判断了当前节点的left不为空
            while(cur != null){
                cur.left.next = cur.right;
                //下一个不为空说明上一层已经帮我们完成串联了
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next; 
            }
            pre = pre.left;
        }
        return root;
    }
}
//11-1
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Node pre = null;
            for(int i = 0; i < len; i++){
                Node cur = queue.poll();
                if(i > 0){
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
//11-2
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node cur = root;
        while(cur != null){
            Node dummy = new Node();
            Node tail = dummy;
            while(cur != null){
                if(cur.left != null){
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if(cur.right != null){
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}
//12
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
//13-1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String s : strs){
            q.offer(s);
        }
        return helper(q);
    }
    private TreeNode helper(Queue<String> q){
        String str = q.poll();
        if("null".equals(str)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//13-2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuffer strb = new StringBuffer("[");
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)){
            return null;
        }
        String[] strs = data.substring(1, data.length()-1).split(",");
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(!"null".equals(strs[i])){
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(cur.left);
            }
            i++;
            if(!"null".equals(strs[i])){
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));