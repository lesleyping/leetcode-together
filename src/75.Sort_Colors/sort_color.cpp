#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    void sort(vector<int>& nums, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, gt = hi, i = lo+1;
        int v = nums[lo];
        while(i <= gt){
            if(nums[i] < v){
                int tmp = nums[i];
                nums[i] = nums[lt];
                nums[lt] = tmp;
                lt++;
                i++;
            }
            else if(nums[i] == v){
                i++;
            }
            else if(nums[i] > v){
                int tmp = nums[i];
                nums[i] = nums[gt];
                nums[gt] = tmp;
                gt--;
            }
        }
        sort(nums, lo, lt-1);
        sort(nums, gt+1, hi);
    }

    void sortColors(vector<int>& nums) {
        sort(nums, 0, nums.size()-1);
    }
};

int main()
{
    Solution s;
    vector<int> nums = {2,0,2,1,1,0};
    s.sortColors(nums);
    for(int i = 0; i < nums.size(); i++){
        cout << nums[i] << endl;
    }
    return 0;
}