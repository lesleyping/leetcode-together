#include<vector>
#include<algorithm>
#include<iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int>& nums, int target) {
        if(nums.size()<4) return {};
        sort(nums.begin(),nums.end());
        vector<vector<int> > res;
        for(int i = 0; i<nums.size()-3; i++)
        {
            if(i>0 && (nums[i] == nums[i-1])) continue;
            for(int j = i+1; j<nums.size()-2; j++)
            {
                int ll = j + 1;
                int rr = nums.size()-1;
                if(j>i+1 && (nums[j] == nums[j-1])) continue;
                while(ll<rr)
                {
                    int tmp = nums[i]+nums[j]+nums[ll]+nums[rr];
                    if(tmp == target){
                        res.push_back({nums[i],nums[j],nums[ll],nums[rr]});
                        ll++;
                        rr--;
                        while((nums[ll] == nums[ll-1]) && (ll<rr))ll++;
                        while((nums[rr] == nums[rr+1]) && (ll<rr))rr--;
                    }
                    else if(tmp > target){
                        rr--;
                    }
                    else if(tmp < target){
                        ll++;
                    }
                }
            }
        }
        return res;
    }
};


int main()
{
    vector<int> nums = {-3,-2,-1,0,0,1,2,3};
    int target = 0;
    Solution S;
    vector<vector<int> > res;
    res = S.fourSum(nums, target);

    for(int i = 0; i < res.size(); i++)
    {
        for(int j = 0; j<res[i].size(); j++)
        {cout << res[i][j] << endl;}
    }
    return 0;
}