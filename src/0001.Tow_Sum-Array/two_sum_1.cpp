#include <iostream>
#include <vector>

// Solution 1 暴力求解（时间复杂度位O（n^2））

class Solution {
 public:
  std::vector<int> twoSum(std::vector<int>& nums, int target) {
    std::vector<int> results;
    for (int i = 0; i < nums.size() - 1; i++) {
      int tmp = 0;
      tmp = target - nums[i];
      for (int j = i + 1; j < nums.size(); j++) {
        if (tmp == nums[j]) {
          results.push_back(i);
          results.push_back(j);
        }
      }
    }
    return results;
  }
};