class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int max = 0;
        while(j < nums.length){
            if (nums[j++] == 0){
                max = Math.max(max, j - 1 - i);
                i = j;
            }
        }
        return Math.max(max, j - i);
    }
}