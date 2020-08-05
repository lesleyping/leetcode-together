class Solution {
public:
    bool hasPath(char* matrix, int rows, int cols, char* str)
    {
        if(matrix == nullptr || rows == 0 || cols == 0 || str == nullptr) return nullptr;
        bool *mark = new bool[rows * cols];
        memset(mark, 0, rows*cols);
        int len = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(hasPathCore(matrix, rows, cols, str, row, col, len, mark))
                    return true;
            }
        }
        delete[] mark;
        return false;
    }
    bool hasPathCore(char* matrix, int rows, int cols, char* str, int row, int col, int len, bool* mark){
        if(str[len] == '\0') return true;
        bool hasPath = false;
        if(row >= 0 && col >= 0 && row < rows && col < cols
          && matrix[cols * row + col] == str[len]
          && !mark[row * cols + col]){
            len++;
            mark[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, str, row, col-1, len, mark)
                || hasPathCore(matrix, rows, cols, str, row, col+1, len, mark)
                || hasPathCore(matrix, rows, cols, str, row-1, col, len, mark)
                || hasPathCore(matrix, rows, cols, str, row+1, col, len, mark);
            if(!hasPath){
                len--;
                mark[row*cols+col] = false;
            }
        }
        return hasPath;
    }

};