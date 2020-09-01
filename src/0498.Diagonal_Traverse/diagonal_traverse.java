/*
早先的c++版本
*/
class Solution {
    public:
        vector<int> findDiagonalOrder(vector<vector<int>>& matrix) {
            vector<int> res;
            int m = matrix.size();
            if(m == 0) return res;
            int n = matrix[0].size();
            if(n == 0) return res;
            int x,y;
            int sum = 0;
            while(sum < m+n){
                if(sum%2 == 0){
                    x = (sum < m) ? sum : m - 1 ;
                    y = sum - x;
                    
                    while(x >= 0 && y < n){
                        res.push_back(matrix[x][y]);
                        x--;
                        y++;
                    }
                }
                else{
                    y = (sum < n) ? sum : n - 1;
                    x = sum - y;
                    
                    while(y >= 0 && x < m){
                        res.push_back(matrix[x][y]);
                        x++;
                        y--;
                    }
                }
                sum++;
            }
            
            return res;
        }
    };

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];
        int[] res = new int[m * n];
        int sum = 0;
        int index = 0;
        int x, y;
        while (sum < m + n){
            if (sum % 2 == 0){
                x = sum < m ? sum : m-1;
                y = sum - x;
                while(x >= 0 && y < n){
                    res[index++] = matrix[x][y];
                    x--;
                    y++;
                }
            }
            else if (sum % 2 == 1){
                y = sum < n ? sum : n-1;
                x = sum - y;
                while (y >= 0 && x < m){
                    res[index++] = matrix[x][y];
                    x++;
                    y--;
                }
            }
            sum++;
        }
        return res;
    }
}