#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int>& nums) {
        if(nums.size()<3) return {};
        vector<vector<int> > result;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < (nums.size()-2); ++i)
        {
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int ll = i+1;
            int rr = nums.size()-1;
            while(ll < rr)
            {
                int sum = nums[i] + nums[ll] + nums[rr];
                if(sum == 0)
                {
                    result.push_back({nums[i],nums[ll],nums[rr]});
                    ll++;
                    rr--;
                    while(ll < rr && nums[ll] == nums[ll-1]) ll++;
                    while(ll < rr && nums[rr] == nums[rr+1]) rr--;
                }
                else if(sum > 0)
                {
                    rr--;
                }
                else if(sum < 0)
                {
                    ll++;
                }
            }
        }
        return result;
    }
};

int main()
{
    vector<int> nums = {1,2,3,0,-1};
    Solution A;
    vector<vector<int> > ans = A.threeSum(nums);
    for(int i = 0; i<ans.size(); ++i)
    {
        for(int j = 0; j<ans[i].size(); ++j)
        {
            cout << ans[i][j] << endl;
        }
    }
    
    return 0;
}
