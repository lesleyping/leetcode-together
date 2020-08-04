class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int ll = 0;
        int rr = nums.size() - 1;
        int mid;
        while(ll <= rr){
            mid = ll + (rr - ll) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[ll] == nums[rr] && nums[ll] == nums[mid]){
                ll++;
                rr--;
            }
            else if(nums[ll] <= nums[mid]){
                if(target >= nums[ll] && target <= nums[mid]){
                    rr = mid - 1;
                }
                else{
                    ll = mid + 1;
                }
            }
            else{
                if(target >= nums[mid] && target <= nums[rr]){
                    ll = mid + 1;
                }
                else{
                    rr = mid - 1;
                }
            }
        }
        return false;
    }
};