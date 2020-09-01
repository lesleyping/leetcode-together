//c++
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if(numRows == 0)return res;
        res.push_back({1});
        vector<int> pre;
        for(int i = 1; i < numRows; i++){
            vector<int> now(i+1,1);
            if(i >= 2){
                for(int j = 1; j < i; j++){
                    now[j] = pre[j] + pre[j-1];
                }
            }
            res.push_back(now);
            pre = now;
        }
        return res;
    }
};
//Java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            res.add(new ArrayList<>());
            for (int j = 0; j < i+1; j++){
                if (j == 0 || j == i){
                    res.get(i).add(1);
                }
                else{
                    res.get(i).add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
        }

        return res;
    }
}