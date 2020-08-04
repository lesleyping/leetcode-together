#include<iostream>
#include<stdlib.h>
#include<vector>

using namespace std;

#define max(a,b) (((a) > (b)) ? (a) : (b))
#define min(a,b) (((a) > (b)) ? (b) : (a))

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.empty())
        {
            if(!nums2.empty())
            {
                int size = nums2.size();
                if(size % 2 == 0)
                    return float((nums2[size/2-1] + nums2[size/2])/2.0);
                else
                    return float(nums2[size/2]);
            }
        }
        if(nums2.empty())
        {
            if(!nums1.empty())
            {
                int size2 = nums1.size();
                if(size2 % 2 == 0)
                    return float((nums1[size2/2-1] + nums1[size2/2])/2.0);
                else
                    return float(nums1[size2/2]);
            }
        }
        vector<int> v = {};
        unsigned int i = 0, j = 0;
        while(i < nums1.size() && j < nums2.size())
        {
            if(nums1[i] < nums2[j])
            {
                v.push_back(nums1[i]);
                ++i;
            }
            else
            {
                v.push_back(nums2[j]);
                ++j;
            }
        }
        while(i < nums1.size())
        {
            v.push_back(nums1[i]);
            ++i;
        }
        while(j < nums2.size())
        {
            v.push_back(nums2[j]);
            ++j;
        }
        
        int index = nums1.size() + nums2.size();
        cout << index << endl;
        if (index % 2 == 0)
            return float((v[index/2-1] + v[index/2])/2.0);
        else
            return float(v[index/2]);
    }
};

class Solution2{
public:
    double findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2){
        int m = nums1.size();
        int n = nums2.size();
        if (m > n)
            return findMedianSortedArrays2(nums2, nums1);
        
        int LMax1,LMax2,RMin1,RMin2,c1,c2;
        int ll = 0, rr = 2 * m;

        while(ll <= rr)
        {
            c1 = (ll + rr)/2;
            c2 = m+n-c1;

            LMax1 = (c1 == 0) ? INT8_MIN : nums1[(c1-1)/2];
            RMin1 = (c1 == 2 * m) ? INT8_MAX : nums1[c1/2];
            LMax2 = (c2 == 0) ? INT8_MIN : nums2[(c2-1)/2];
            RMin2 = (c2 == 2* n) ? INT8_MAX : nums2[c2/2];

            if (LMax1 > RMin2)
                rr = c1 - 1;
            else if (LMax2 > RMin1)
                ll = c1 + 1;
            else
                break;
        }
        return ((max(LMax1,LMax2) + min(RMin1,RMin2)) / 2.0);
    }
};

int main()
{
    std::vector<int> v1 = {100};
    std::vector<int> v2 = {101};
    double res;
    Solution2 A;
    res = A.findMedianSortedArrays2(v1,v2);
    cout << res << endl;
    return 0;
}