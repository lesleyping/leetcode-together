//BFS
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
//DFS
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
//并查集
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