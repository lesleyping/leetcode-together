//1-1 BFS
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        boolean[][] mark = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (!mark[i][j] && grid[i][j] == '1'){
                    count++;
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i*n+j);
                    mark[i][j] = true;
                    while(!q.isEmpty()){
                        int tmp = q.poll();
                        int curx = tmp/n;
                        int cury = tmp%n;
                        for(int[] dir : dirs){
                            int newx = curx + dir[0];
                            int newy = cury + dir[1];
                            if (newx >= 0 && newx < m && newy >= 0 && newy < n && !mark[newx][newy] 
                                && grid[newx][newy] == '1'){
                                q.offer(newx * n + newy);
                                mark[newx][newy] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
//1-2 DFS
class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        boolean[][] mark = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(!mark[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n, mark);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int x, int y, int m, int n, boolean[][] mark){
        mark[x][y] = true;
        for(int[] dir : dirs){
            int newx = x + dir[0];
            int newy = y + dir[1];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n &&
               !mark[newx][newy] && grid[newx][newy] == '1'){
                dfs(grid, newx, newy, m, n, mark);
            }
        }
    }
}
//1-3 并查集
class Solution {
    int[][] dirs = { {0, 1}, {1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        UnionFind union = new UnionFind(m * n + 1);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    for(int[] dir : dirs){
                        int newx = i + dir[0];
                        int newy = j + dir[1];
                        if(newx < m && newy < n && grid[newx][newy] == '1'){
                            union.union(newx * n + newy, i * n + j);
                        }
                    }
                }
                else{
                    union.union(i * n + j, m * n);
                }
            }
        }
        return union.count - 1;
    }
    private class UnionFind{
        private int[] parent;
        private int count;

        public UnionFind(int n){
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int p){
            while(p != parent[p]){
                parent[p] = find(parent[p]);
                p = parent[p];
            }
            return parent[p];
        }

        public void union(int p, int q){
            int proot = find(p);
            int qroot = find(q);
            if (proot == qroot){
                return ;
            }
            parent[proot] = qroot;
            count--;
        }
    }
}
//2
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        Set<String> dead = new HashSet<>();
        for (String d : deadends){
            dead.add(d);
        }

        if (dead.contains("0000")){
            return -1;
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;
        while(!q.isEmpty()){
            for(int i = q.size(); i > 0; i--){
                String node = q.poll();
                if (node.equals(target)){
                    return step;
                }
                List<String> nexts = getNext(node);
                for(String n : nexts){
                    if(!visited.contains(n) && !dead.contains(n)){
                        q.offer(n);
                        visited.add(n);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public List<String> getNext(String node){
        List<String> nexts = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            StringBuilder str = new StringBuilder(node);
            char c = str.charAt(i);
            str.setCharAt(i, (c == '0' ? '9' : (char)(c - 1)));
            nexts.add(str.toString());
            
            str.setCharAt(i, (c == '9' ? '0' : (char)(c + 1)));
            nexts.add(str.toString());
            
        }
        return nexts;
    }
}
//3-1 回溯法
class Solution {
    public int numSquares(int n) {
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }
    public int numSquaresHelper(int n, HashMap<Integer, Integer> map){
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n == 0){
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            count = Math.min(count, numSquaresHelper(n - i*i, map) + 1);
        }
        map.put(n, count);
        return count;
    }
}
//3-2 动态规划
class Solution {
    static List<Integer> dp = new ArrayList<>();
    public int numSquares(int n) {
        if(dp.size() == 0){
            dp.add(0);
        }
        if (dp.size() <= n){
            for(int i = dp.size(); i <= n; i++){
                int min = Integer.MAX_VALUE;
                for(int j = 1; j * j <= i; j++){
                    min = Math.min(min, dp.get(i-j*j)+1);
                }
                dp.add(min);
            }
        }
        return dp.get(n);
    }
}
//3-3 BFS
class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(n);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int j = 1; j <= Math.sqrt(cur); j++){
                    if ((cur - j * j) == 0){
                        return step;
                    }
                    else{
                        if(!visited.contains(cur - j * j)){
                            q.offer(cur - j * j);
                            visited.add(cur - j * j);
                        }
                    }
                }
            }
        }
        return step;
    }
}
//4-1
class MinStack {
    private Stack<Integer> s;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if (s.peek() == min){
            s.pop();
            min = s.pop();
        }
        else{
            s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//4-2 链表
class MinStack {
    private Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (head == null){
            head = new Node(x, x);
        }
        else{
            head = new Node(x, Math.min(x, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;
        private Node(){}
        private Node(int val, int min){
            this(val, min, null);
        }
        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 //5
class Solution {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<>();
        char[] strs = s.toCharArray();
        for(char str : strs){
            if (str == '(' || str == '[' || str == '{'){
                sta.push(str);
            }
            else{
                if (sta.isEmpty()){
                    return false;
                }
                else{
                    if ((sta.peek() == '[' && str == ']') || (sta.peek() == '{' && str == '}')
                        || (sta.peek() == '(' && str == ')') ){
                        sta.pop();
                    }
                    else return false;
                }
            }
        }
        return sta.isEmpty();
    }
}
//6
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> sta = new Stack<>();
        int[] res = new int[T.length];
        sta.push(0);
        for (int i = 1; i < T.length; i++){
            while(!sta.isEmpty() && T[i] > T[sta.peek()]){
                int tmp = sta.pop();
                res[tmp] = i - tmp;
            }
            sta.push(i);
        }
        while (!sta.isEmpty()){
            int tmp = sta.pop();
            res[tmp] = 0;
        }
        return res;
    }
}
//7
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sta = new Stack<>();
        int tmp1, tmp2;
        for (String s : tokens){
            switch(s){
                case("+"):
                    tmp1 = sta.pop();
                    tmp2 = sta.pop();
                    sta.push(tmp2 + tmp1);
                    break;
                case("-"):
                    tmp1 = sta.pop();
                    tmp2 = sta.pop();
                    sta.push(tmp2 - tmp1);
                    break;
                case("*"):
                    tmp1 = sta.pop();
                    tmp2 = sta.pop();
                    sta.push(tmp2 * tmp1);
                    break;
                case("/"):
                    tmp1 = sta.pop();
                    tmp2 = sta.pop();
                    sta.push(tmp2 / tmp1);
                    break;
                default:
                    sta.push(Integer.valueOf(s));
            }
        }
        return sta.peek();
    }
}
//8-1 DFS
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }
    private Node dfs(Node node, Map<Node,Node> lookup){
        if (node == null) return null;
        if (lookup.containsKey(node)){
            return lookup.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for(Node n : node.neighbors){
            clone.neighbors.add(dfs(n,lookup));
        }

        return clone;
    }
}
// 8-2
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        q.offer(node);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(Node n : tmp.neighbors) {
                if(!lookup.containsKey(n)){
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    q.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}
//9-DFS
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }
    private int dfs(int[] nums, int target, int left){
        if (left == nums.length && target == 0){
            return 1;
        }
        if (left >= nums.length){
            return 0;
        }
        int res = 0;
        res += dfs(nums, target - nums[left], left+1);
        res += dfs(nums, target + nums[left], left+1);
        return res;
    }
}
//10-DFS1
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode node){
        if (node == null) return;
        dfs(res, node.left);
        res.add(node.val);
        dfs(res, node.right);
    }
}
//10-DFS2
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> sta = new Stack<>();
        while(!sta.isEmpty() || root != null){
            while(root != null){
                sta.push(root);
                root = root.left;
            }
            root = sta.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//11
class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!popStack.isEmpty()){
            return popStack.pop();
        }
        else{
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!popStack.isEmpty()){
            return popStack.peek();
        }
        else{
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (popStack.isEmpty() && pushStack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 //12
 class MyStack {
    Queue<Integer> q = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while(size > 1){
            q.offer(q.poll());
            size--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 //13-1
 class Solution {
    public String decodeString(String s) {
        Stack<Integer> intSta = new Stack<>();
        Stack<String> strSta = new Stack<>();
        String res = "";
        int multi = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '['){
                intSta.push(multi);
                strSta.push(res);
                multi = 0;
                res = "";
            }
            else if(s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = intSta.pop();
                for (int j = 0; j < cur_multi; j++){
                    tmp.append(res);
                }
                res = strSta.pop() + tmp;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                multi = multi * 10 + Integer.parseInt(s.charAt(i) + "");
            }
            else{
                res += s.charAt(i);
            }
        }
        return res;
    }
}
//13-2
class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int left){
        int multi = 0;
        StringBuilder str = new StringBuilder();
        while(left < s.length()){
            if (s.charAt(left) >= '0' && s.charAt(left) <= '9'){
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(left)));
            }else if(s.charAt(left) == '['){
                String[] tmp = dfs(s, left+1);
                left = Integer.parseInt(tmp[0]);
                while(multi > 0){
                    str.append(tmp[1]);
                    multi--;
                }
            }else if(s.charAt(left) == ']'){
                return new String[]{String.valueOf(left), str.toString()};
            }else{
                str.append(s.charAt(left));
            }
            left++;
        }
        return new String[]{str.toString()};
    }
}

//14-1
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int m = image.length;
        if (m == 0){
            return image;
        }
        int n = image[0].length;
        int oldcolor = image[sr][sc];
        if (oldcolor == newColor) return image;

        Queue<Integer> q = new LinkedList<>();
        q.offer(sr * n + sc);
        image[sr][sc] = newColor;

        while(!q.isEmpty()){
            int tmp = q.poll();
            for (int[] dir : dirs){
                int newx = tmp/n + dir[0];
                int newy = tmp%n + dir[1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n){
                    if (image[newx][newy] == oldcolor){
                        image[newx][newy] = newColor;
                        q.offer(newx * n + newy);
                    }
                }
            }
        }
        return image;
    }
}
//14-2
class Solution {
    public int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length){
            return ;
        }
        if (oldColor != image[sr][sc]) return ;
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            dfs(image, sr + dir[0], sc + dir[1], newColor, oldColor);
        }
    }
}
//14-3
class Solution {
    public int[][] dirs = {{0, 1}, {1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        if (m == 0) return image;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;
        UnionFind u = new UnionFind(m * n);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (image[i][j] == oldColor){
                    for(int[] dir : dirs){
                        int newx = i + dir[0];
                        int newy = j + dir[1];
                        if( newx >= 0 && newx < m && newy >= 0 
                            && newy < n && image[newx][newy] == oldColor){
                            u.union(i * n + j, newx * n + newy);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (u.isConnected(sr*n+sc, i*n+j)){
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
    private class UnionFind{
        private int[] parent;

        private UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int find(int n){
            while(n != parent[n]){
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return parent[n];
        }

        private void union(int m, int n){
            int mroot = find(m);
            int nroot = find(n);
            if (mroot == nroot){
                return;
            }
            parent[mroot] = nroot;
        }

        private boolean isConnected(int m, int n){
            return find(m) == find(n);
        }
    } 
}
//15
class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    q.offer(i * n + j);
                }
                else if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int[] dir : dirs){
                int newx = tmp/n + dir[0];
                int newy = tmp%n + dir[1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n && matrix[newx][newy] == -1){
                    matrix[newx][newy] = matrix[tmp/n][tmp%n] + 1;
                    q.offer(newx * n + newy);
                }
            }
        }
        return matrix;
    }
}
//16-1
class Solution {
    Set<Integer> searched = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int tmp = q.poll();
            searched.add(tmp);
            List<Integer> room = rooms.get(tmp);
            for(int n : room){
                if(!searched.contains(n)){
                    q.offer(n);
                }
            }
        }
        return searched.size() == rooms.size();
    }
}
//16-2
class Solution {
    Set<Integer> searched = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        dfs(rooms, 0);
        return searched.size() == rooms.size();
    }
    public void dfs(List<List<Integer>> rooms, int n){
        searched.add(n);
        List<Integer> room = rooms.get(n);
        for(int r : room){
            if (!searched.contains(r)){
                dfs(rooms, r);
            }
        }
    }
}