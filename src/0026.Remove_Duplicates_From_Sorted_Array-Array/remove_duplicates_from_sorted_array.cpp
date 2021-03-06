#include<iostream>
#include<vector>

using namespace std;

class Solution{
public:
    int removeDuplicates(vector<int>& nums){
        if(nums.size() < 2) return nums.size();
        int i = 1;
        while(i < nums.size()){
            if(nums[i]==nums[i-1]){
                nums.erase(nums.begin()+i);
            }
            else i++;
        }
        return nums.size();
    }

    int removeDuplicates2(vector<int>& nums){
        if(nums.size()<2) return nums.size();
        int i = 0;
        for(int j = 1; j<nums.size(); j++)
        {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
};

int main()
{
    vector<int> nums = {1,1,2};
    Solution S;
    int res = S.removeDuplicates(nums);
    cout << res << endl;
    return 0;
}