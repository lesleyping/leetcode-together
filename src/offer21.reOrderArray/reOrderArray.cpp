class Solution1 {
public:
    void reOrderArray(vector<int> &array) {
        if (array.size() == 0) return ;
        int ll = 0;
        int rr = array.size()-1;
        while (ll < rr){
            while ((array[ll] % 2 != 0) && ll < rr){
                ll++;
            }
            while ((array[rr] % 2 == 0) && ll < rr){
                rr--;
            }
            if (ll < rr)
                swap(array, ll, rr);
        }
    }
    void swap(vector<int> &array, int l, int r){
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
};
class Solution2 {
public:
    void reOrderArray(vector<int> &array) {
        if (array.size() == 0) return ;
        int len = array.size();
        for (int i = 1; i < len; i++){
            int tmp = array[i];
            if (tmp % 2 == 1){
                int j;
                for (j = i-1; j >= 0 && array[j] % 2 == 0; j--){
                    array[j+1] = array[j];
                }
                array[j+1] = tmp;
            }
        }
    }
};
class Solution3 {
public:
    void reOrderArray(vector<int> &array) {
        if (array.size() == 0) return ;
        int len = array.size();
        vector<int> res;
        for (int v : array){
            if (v&1) res.push_back(v);
        }
        for (int v : array){
            if (!(v&1)) res.push_back(v);
        }
        copy(res.begin(), res.end(), array.begin());
    }
    
};