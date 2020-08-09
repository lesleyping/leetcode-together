class Solution1 {
public:
    vector<int> printMatrix(vector<vector<int> > matrix) {
        vector<int> res;
        int rows = matrix.size();
        if (rows == 0) return res;
        int cols = matrix[0].size();
        if (cols == 0) return res;
        int start = 0;
        while (rows > start*2 && cols > start*2){
            printMatrixCore(matrix, start, res, rows, cols);
            start++;
        }
        return res;
    }
    void printMatrixCore(vector<vector<int>>& matrix, int start, vector<int>& res, int rows, int cols){
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        if (endX >= start){
            for (int i = start; i <= endX; i++){
                res.push_back(matrix[start][i]);
            }
        }
        if (endY > start){
            for (int i = start+1; i <= endY; i++){
                res.push_back(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY){
            for (int i = endX-1; i >= start; i--){
                res.push_back(matrix[endY][i]);
            }
        }
        if ((endY > start + 1) && start < endX){
            for (int i = endY-1; i > start; i--){
                res.push_back(matrix[i][start]);
            }
        }
    }
};

class Solution2 {
public:
    vector<int> printMatrix(vector<vector<int> > matrix) {
        vector<int> res;
        if (matrix.empty()) return res;
        int up = 0, left = 0;
        int down = matrix.size() - 1;
        int right = matrix[0].size() - 1;
        while(up <= down && left <= right){
            for (int i = left; i <= right; i++)
                res.push_back(matrix[up][i]);
            if (++up > down) break;
            
            for (int i = up; i <= down; i++)
                res.push_back(matrix[i][right]);
            if (--right < left) break;
            
            for (int i = right; i >= left; i--)
                res.push_back(matrix[down][i]);
            if (--down < up) break;
            
            for (int i = down; i >= up; i--)
                res.push_back(matrix[i][left]);
            if (++left > right) break;
        }
        
        return res;
    }
    
};