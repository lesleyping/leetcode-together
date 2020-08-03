class Solution {
public:
    bool Find(int target, vector<vector<int> > array) {
        bool find = false;
        int row = array.size();
        int col = array[0].size();
        if( row > 0 && col > 0){
            int r = 0;
            int c = col - 1;
            while(r < row && c >=0){
                if(array[r][c] > target)
                    c--;
                else if(array[r][c] < target)
                    r++;
                else{
                    find = true;
                    break;
                }
            }
        }
        return find;
    }
};