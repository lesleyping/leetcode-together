class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(res, nums, used, 0, new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, boolean[] used, int count, List<Integer> tmp) {
        if (count == nums.length) {
            res.add(new ArrayList(tmp));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                tmp.add(nums[i]);
                used[i] = true;
                helper(res, nums, used, count+1, tmp);
                used[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}