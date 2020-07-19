#include<vector>
#include<iostream>

using namespace std;

class Solution{
public:
    vector<int> searchRange(vector<int>& nums, int target){
        vector<int> res(2,-1);
        if(nums.empty()) return res;
        res[0] = left_bound(nums, target);
        if(res[0] == -1) return res;
        res[1] = right_bound(nums, target);
        return res;
    }

    int left_bound(vector<int>& nums, int target){
        int left = 0;
        int right = nums.size()-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) right = mid - 1;
            else if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
        }
        if(left < nums.size() && nums[left] == target) return left;
        return -1;
    }

    int right_bound(vector<int>& nums, int target){
        int left = 0;
        int right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
        }
        if(right >= 0 && nums[right] == target) return right;
        return -1;
    }
};

int main(){
    Solution S;
    vector<int> nums = {5,7,7,8,8,10};
    int target = 8;
    vector<int> res = S.searchRange(nums,target);
    for(int i=0; i < 2; i++)
    {
        cout << res[i] << endl;
    }
    return 0;
}