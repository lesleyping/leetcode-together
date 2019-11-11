#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
using namespace std;

#define max(a,b) ((a) > (b) ? (a) : (b));

class Solution{
public:
    int maxSubArray(vector<int>& nums){
        vector<int> res(nums.size());
        res[0] = nums[0];
        for(int i = 1; i < nums.size(); i++){
            if(res[i-1] < 0){
                res[i] = nums[i];
            }
            else{
                res[i] = res[i-1] + nums[i];
            }
        }
        // for(int i = 0; i<res.size(); i++){
        //     cout << res[i] << endl;
        // }
        auto maxindex = max_element(res.begin(), res.end());
        return res[maxindex - res.begin()];
    }
};

class Solution2{
public:
    int maxSubArray(vector<int>& nums){
        int res = INT_MIN;
        int size = nums.size();
        res = maxSubArraysub(nums, 0, size-1);
        return res;
    }

    int maxSubArraysub(vector<int>& nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        int mid = (left + right)/2;
        int leftSum = maxSubArraysub(nums, left, mid);
        int rightSum = maxSubArraysub(nums, mid + 1, right);
        int midSum = find(nums, left, mid, right);
        int result = max(leftSum, rightSum);
        result = max(result, midSum);
        return result;
    }

    int find(vector<int>& nums, int left, int mid, int right){
        int leftSum = INT_MIN;
        int sum = 0;
        for(int i = mid; i >= left; i--){
            sum += nums[i];
            leftSum = max(leftSum, sum);
        }

        int rightSum = INT_MIN;
        sum = 0;
        for(int j = mid+1; j <= right; j++){
            sum += nums[j];
            rightSum = max(rightSum, sum);
        }

        return (leftSum + rightSum);
    }
};

int main()
{
    vector<int> nums = {-2,1,-3,4,-1,2,1,-5,4};
    Solution2 S;
    int res = S.maxSubArray(nums);
    
    cout << res << endl;
    
    return 0;
}