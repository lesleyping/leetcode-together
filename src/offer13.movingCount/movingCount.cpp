class Solution {
public:
    int movingCount(int threshold, int rows, int cols)
    {
        if (rows == 0 || cols == 0) return 0;
        int count = 0;
        bool* mark = new bool[rows * cols];
        memset(mark, false, rows*cols);
        
        count = movingCountCore(threshold, rows, cols, 0, 0, mark);
        delete[] mark;
        return count;
    }
    int movingCountCore(int threshold, int rows, int cols, int row, int col, bool* mark){
        int count = 0;
        if(check(threshold, rows, cols, row, col, mark)){
            count++;
            mark[row * cols + col] = true;
            count += movingCountCore(threshold, rows, cols, row-1, col, mark)
                    + movingCountCore(threshold, rows, cols, row, col+1, mark)
                    + movingCountCore(threshold, rows, cols, row+1, col, mark)
                    + movingCountCore(threshold, rows, cols, row, col-1, mark);
        }
        return count;
    }
    bool check(int threshold, int rows, int cols, int row, int col, bool* mark){
        if(row >= 0 && row < rows && col >= 0 && col < cols && getsum(row) + getsum(col) <= threshold && !mark[cols * row + col])
            return true;
        return false;
    }
    int getsum(int m){
        int sum = 0;
        while(m > 0){
            sum += m%10;
            m /= 10;
        }
        return sum;
    }
};