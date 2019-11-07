#include<vector>
#include<iostream>
#include<cmath>
#include<algorithm>

using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int res = nums[0] + nums[1] + nums[2];
        for(int k = 0; k < nums.size()-2; k++)
        {
            int ll = k+1;
            int rr = nums.size() - 1;
            while(ll<rr)
            {
                int tmp = nums[k]+nums[ll]+nums[rr];
                if(abs(target-res) > abs(tmp-target))
                {
                    res = tmp;
                }
                if(tmp > target)
                {
                    rr--;
                }
                else if(tmp < target)
                {
                    ll++;
                }
                else if(tmp == target)
                {
                    return tmp;
                }
            }
        }
        return res;
    }
};

int main()
{
    int target = 1;
    vector<int> nums = {-1,2,1,-4};
    Solution A;
    int res = A.threeSumClosest(nums,target);
    cout << res << endl;
    return 0;
}