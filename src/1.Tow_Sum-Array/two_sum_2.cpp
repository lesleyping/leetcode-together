#include <unordered_map>
#include <vector>

class Solution {
 public:
  std::vector<int> twoSum(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> nums_map;
    std::vector<int> results;
    for (int i = 0; i < nums.size(); i++) {
      auto it = nums_map.find(target - nums[i]);
      if (it == nums_map.end())
        nums_map.insert({nums[i], i});
      else {
        results.push_back(it->second);
        results.push_back(i);
      }
    }
    return results;
  }
};