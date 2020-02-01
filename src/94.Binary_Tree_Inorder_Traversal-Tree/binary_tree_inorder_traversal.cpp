#include<iostream>
#include<string>
#include<vector>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> res;
    vector<int> inorderTraversal(TreeNode* root) {
        if(root!=NULL){
            inorderTraversal(root->left);
            res.push_back(root->val);
            inorderTraversal(root->right);
        }
        return res;
    }
};

#include<stack>
class Solution1{
public:
    vector<int> inorderTraversal(TreeNode* root){
        vector<int> v;
        TreeNode *rt = root;
        stack<TreeNode*> S;
        while(rt || S.size()){
            while(rt){
                S.push(rt);
                rt = rt->left;
            }
            rt = S.top();S.pop();
            v.push_back(rt->val);
            rt = rt->right;
        }
        return v;
    }
};

int main()
{
    Solution S;
    vector res = S.inorderTraversal();
    return 0;
}