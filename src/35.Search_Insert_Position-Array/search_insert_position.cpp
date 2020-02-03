#include<iostream>
#include<vector>

using namespace std;

class Solution{
public:
    int searchInsert(vector<int>& nums, int target){
        int n = nums.size();
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
        }
        return left;
    }
};

int main()
{
    vector<int> nums = {1,3,5,6};
    int target = 0;
    Solution S;
    int res = S.searchInsert(nums, target);
    cout << res << endl;
    return 0;
}