public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited = new boolean[matrix.length];
        int idx = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(check(matrix, rows, cols, str, i, j, idx, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[] matrix, int rows, int cols, char[] str, 
                          int row, int col, int idx, boolean[] visited){
        if(idx == str.length){
            return true;
        }
        boolean flag = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols
              && !visited[row * cols + col]
              && matrix[row * cols + col] == str[idx]){
            idx++;
            visited[row * cols + col] = true;
            flag = check(matrix, rows, cols, str, row-1, col, idx, visited)
                    || check(matrix, rows, cols, str, row, col+1, idx, visited)
                    || check(matrix, rows, cols, str, row+1, col, idx, visited)
                    || check(matrix, rows, cols, str, row, col-1, idx, visited);
            if(!flag){
                idx--;
                visited[row * cols + col] = false;
            }
        }
        return flag;
    }
}