#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> res;
    vector<int> path;
    vector<int> candidates;

    void DFS(int begin, int target){
        if(target == 0){
            res.push_back(path);
            return;
        }
        for(int i = begin; i < candidates.size() && target - candidates[i] >= 0; i++){
            path.push_back(candidates[i]);
            DFS(i, target - candidates[i]);
            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end()); 
        this->candidates = candidates;       
        DFS(0,target);
        return res;
    }
};

int main()
{
    vector<int> nums = {2,3,6,7};
    int target = 7;
    Solution S;
    vector<vector<int>> res = S.combinationSum(nums, target);
    return 0;
}