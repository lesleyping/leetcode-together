class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] < nums[right]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                } else{
                    right = mid - 1;
                }
            } else if(nums[mid] > nums[right]){
                if(nums[left] <= target && target <= nums[mid - 1]){
                    right = mid - 1;
                } else{
                    left = mid;
                }
            } else{
                if(nums[right] == target){        //!!!!!!!!!!!!!!!!!!!
                    return true;
                }
                right--;
            }
        }
        if(nums[left] == target){
            return true;
        }
        return false;
    }
}