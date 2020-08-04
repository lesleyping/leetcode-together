class Solution {
public:
    vector<int> candidates;
    vector<int> path;
    vector<vector<int>> res;

    void DFS(int begin, int target){
        if(target == 0){
            res.push_back(path);
            return;
        }
        for(int i = begin; i < candidates.size() && target - candidates[i] >= 0; i++){
            
            if(i > begin && candidates[i-1] == candidates[i]) continue; //important
            path.push_back(candidates[i]);
            
            DFS(i+1, target - candidates[i]);
            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        this->candidates = candidates;
        DFS(0, target);
        return res;
    }
};