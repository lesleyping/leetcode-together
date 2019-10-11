#include<iostream>
#include<stdlib.h>
#include<vector>

using namespace std;

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
        
    }
}

int main()
{
    std::vector<int> v1 = {1,3,5,8};
    std::vector<int> v2 = {2,4,6};
    double res;
    Solution A;
    res = A.findMedianSortedArrays(v1,v2);
    cout << res << endl;
    return 0;
}