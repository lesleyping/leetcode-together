class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                return res;
            }
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int tmp = nums[k] + nums[i] + nums[j];
                if (tmp == 0) {
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i < j && nums[i] == nums[i+1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j-1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if(tmp > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}