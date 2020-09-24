//1
class Solution {
    public int maxValue(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
                }

            }
        }
        return grid[m-1][n-1];
    }
}
//2
class Solution {
    public int maxValue(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < n; i++){//！！！！范围
            grid[0][i] += grid[0][i-1];
        }
        for(int j = 1; j < m; j++){ //!!!!!范围
            grid[j][0] += grid[j-1][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}