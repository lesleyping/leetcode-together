class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);				//!!!!!!!!!!!!!!!!!!
        helper(res, nums, used, 0, new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, boolean[] used, int count, List<Integer> tmp) {
        if (count == nums.length) {
            res.add(new ArrayList(tmp));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            helper(res, nums, used, count+1, tmp);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}