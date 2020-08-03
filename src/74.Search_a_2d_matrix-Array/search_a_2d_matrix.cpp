class Solution1 {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size()==0 || matrix[0].size()==0) return false;
        int i = matrix.size()-1;
        int j = 0;
        while(i<matrix.size() && j<matrix[0].size() && i>=0 && j>=0){
            if(matrix[i][j] == target){
                return true;
                break;
            }
            else if(matrix[i][j] < target){
                j++;
            }
            else if(matrix[i][j] > target){
                i--;
            }
        }
        return false;
    }
};
class Solution2 {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()) return false;
        int ll = 0, mm = 0, rr = 0;
        int m = matrix.size();
        int n = matrix[0].size();


        rr = m * n - 1;
        while(ll <= rr){
            mm = ll + (rr - ll)/2;
            if(matrix[mm/n][mm%n] == target) return true;
            else if(matrix[mm/n][mm%n] < target) ll = mm + 1;
            else if(matrix[mm/n][mm%n] > target) rr = mm - 1;
        }
        return false;
    }
};
