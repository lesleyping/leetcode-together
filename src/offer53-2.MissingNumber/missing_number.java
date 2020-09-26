class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == mid){        //向右走
                left = mid + 1;
            }else if(nums[mid] != mid){
                right = mid;
            }
        }
        //如果0~n-1都不缺值，那么缺少的是n
        return (left == nums.length - 1 && nums[left] == left) ? left + 1 : left;
    }
}