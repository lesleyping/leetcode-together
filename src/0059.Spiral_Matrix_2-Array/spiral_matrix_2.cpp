class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        if(n == 0)return {{}};
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        vector<vector<int>> res(n,vector<int>(n,0));
        int tmp = 1;
        while(true){
            for(int i = left; i <= right; i++) res[top][i] = tmp++;
            if(++top > down) break;
            
            for(int i = top; i <= down; i++) res[i][right] = tmp++;
            if(--right < left) break;


            for(int i = right; i >= left; i--) res[down][i] = tmp++;
            if(--down < top) break;


            for(int i = down; i >= top; i--) res[i][left] = tmp++;
            if(++left > right) break;
        }
        return res;
    }
};