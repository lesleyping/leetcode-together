class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size();
        vector<int> res;
        if(m == 0) return res;
        int n = matrix[0].size();
        int left = 0, up = 0;
        int right = n-1;
        int down = m-1;
        while(true){
            for(int i = left; i <= right; i++)res.push_back(matrix[up][i]);
            if(++up > down)break;
            for(int i = up; i <= down; i++)res.push_back(matrix[i][right]);
            if(--right < left)break;
            for(int i = right; i>= left; i--)res.push_back(matrix[down][i]);
            if(--down < up)break;
            for(int i = down; i >= up; i--)res.push_back(matrix[i][left]);
            if(++left > right)break;
        }
            
        return res;
    }
};
