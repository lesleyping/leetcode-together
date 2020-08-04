class Solution {
public:
    int findMin(vector<int>& nums) {
        int ll = 0;
        int rr = nums.size() - 1;
        int mid = ll;
        while(nums[ll] > nums[rr]){
            if((rr - ll) == 1){
                mid = rr;
                break;
            }
            mid = ll + (rr - ll) / 2;
            if(nums[ll] <= nums[mid]){
                ll = mid;
            }
            else if(nums[mid] <= nums[rr]){
                rr = mid;
            }
        }
        return nums[mid];
    }
};