class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0; i < n; i++){
            while(nums[i] != i+1){
                if(nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i]-1]) break;//important
                int tmp = nums[i] - 1;
                nums[i] = nums[tmp];
                nums[tmp] = tmp + 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
};