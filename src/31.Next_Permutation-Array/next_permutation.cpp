#include<iostream>
#include<vector>

using namespace std;

class Solution{
public:
    void nextPermutation(vector<int>& nums){
        int i = nums.size()-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.size()-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        if(nums.size()>1){
            reverse(nums, i+1, nums.size()-1);
        }
        
        // for(int i=0; i<nums.size(); i++){
        //     cout << nums[i] << endl;
        // }
    }

    void swap(vector<int>& nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void reverse(vector<int>& nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
};

int main()
{
    vector<int> nums = {};
    Solution S;
    S.nextPermutation(nums);
    
    return 0;
}