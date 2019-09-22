#include<vector>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> results;
        for(int i = 0; i<nums.size()-1; i++){
            int tmp=0;
            tmp = target - nums[i];
            for(int j = i+1; j < nums.size(); j++){
                if (tmp == nums[j]){
                    results.push_back(i);
                    results.push_back(j);
                }
            }
        }
        return results;
    }
};