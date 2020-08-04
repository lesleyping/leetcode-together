class Solution {
public:
    int findMin(vector<int>& nums) {
        int ll = 0;
        int rr = nums.size()-1;
        int mid = ll;
        while(nums[ll] >= nums[rr]){
            mid = ll + (rr - ll) / 2;
            if((rr - ll) == 1){
                mid = rr;
                break;
            }
            if(nums[ll] == nums[rr] && nums[ll] == nums[mid]){
                return Minorder(nums, ll, rr);
            }
            else if(nums[mid] >= nums[ll]){
                ll = mid;
            }
            else if(nums[mid] <= nums[rr]){
                rr = mid;
            }
        }
        return nums[mid];
    }
    int Minorder(vector<int>& nums, int ll, int rr){
        int res = nums[ll];
        for(int i = ll + 1; i <= rr; i++){
            if(res > nums[i]){
                res = nums[i];
            }
        }
        return res;
    }
};