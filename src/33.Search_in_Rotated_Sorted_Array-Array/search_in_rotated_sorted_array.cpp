#include<iostream>
#include<vector>

using namespace std;

class Solution{
public:
    int search(vector<int>& nums, int target){
        int mid;
        int ll = 0;
        int rr = nums.size()-1;
        while(ll < rr){
            mid = (ll + rr)/2;
            if(nums[0] <= nums[mid] && (target < nums[0] || target > nums[mid])){
                ll = mid+1;
            }
            else if(nums[0] > nums[mid] && (target < nums[0] && target > nums[mid])){
                ll = mid+1;
            }
            else{
                rr = mid;
            }
        }
        return (ll == rr && nums[ll] == target) ? ll : -1;
    }
};

class Solution2 {
public:
    int search(vector<int>& nums, int target) {
        int ll = 0;
        int rr = nums.size() - 1;
        while(ll <= rr){
            int mid = ll + (rr - ll)/2;
            if(nums[mid] == target) return mid;
            if(nums[ll] <= nums[mid]){
                if(nums[ll] > target || nums[mid] < target){
                    ll = mid + 1;
                }
                else{
                    rr = mid - 1;
                }
            }
            else{
                if(target < nums[ll] && target > nums[mid]){
                    ll = mid + 1;
                }
                else{
                    rr = mid - 1;
                }
            }
        }
        return -1;
    }
};

int main()
{
    vector<int> nums = {4,5,6,7,0,1,2};
    int target = 0;
    Solution S;
    int res = S.search(nums, target);
    cout << res << endl;
    return 0;
}
