public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited = new boolean[rows * cols];
        int cnt = check(threshold, rows, cols, visited, 0, 0);
        return cnt;
    }
    private int check(int threshold, int rows, int cols, boolean[] visited, int row, int col){
       int cnt = 0;
        if(row >= 0 && row < rows && col >= 0 && col < cols
              && !visited[row * cols + col] && small(row, col, threshold)){
            visited[row * cols + col] = true;
            cnt = 1 + check(threshold, rows, cols, visited, row-1, col)
                    + check(threshold, rows, cols, visited, row, col+1)
                    + check(threshold, rows, cols, visited, row+1, col)
                    + check(threshold, rows, cols, visited, row, col-1);
        }
        return cnt;
    }
    private boolean small(int row, int col, int threshold){
        int sumRow = 0;
        while(row != 0){
            sumRow += row % 10;
            row /= 10;
        }
        int sumCol = 0;
        while(col != 0){
            sumCol += col % 10;
            col /= 10;
        }
        return ((sumRow + sumCol) <= threshold);
    }
}