class Solution {
    public int search(int[] nums, int target) {
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
            } else{
                if(nums[left] <= target && target <= nums[mid - 1]){
                    right = mid - 1;
                } else{
                    left = mid;
                }
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}