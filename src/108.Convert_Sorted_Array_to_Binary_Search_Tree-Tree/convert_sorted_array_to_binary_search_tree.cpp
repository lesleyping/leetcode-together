#include<vector>
#include<iostream>

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x):val(x), left(NULL), right(NULL) {}
};

class Solution{
public:
    TreeNode* sortedArrayToBST(vector<int>& nums){

    }
};

int main(){
    Solution S;
    vector<int> nums = {-10,-3,0,5,9};
    TreeNode *res = S.sortedArrayToBST(nums);
    cout<<res->val;
    return 0;
}