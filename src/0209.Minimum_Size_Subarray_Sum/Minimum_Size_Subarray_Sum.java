//c++滑窗法
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int l = 0;
        int r = 0;
        int len = INT_MAX;
        int sum = 0;
        while(r < nums.size()){
            sum += nums[r];
            r++;
            while(sum >= s){
                len = min(len, r - l);
                sum -= nums[l];
                l++;
            }
        }
        if(len == INT_MAX) len = 0;
        return len;
    }
};
//Java

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length){
            sum += nums[r];
            r++;
            while(sum >= s){
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}