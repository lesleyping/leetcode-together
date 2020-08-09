/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* reConstructBinaryTree(vector<int> pre,vector<int> vin) {
        if(pre.size() == 0 || vin.size() != pre.size()) return nullptr;
        return Construct(pre, vin, 0, pre.size()-1, 0, vin.size()-1);
    }
    TreeNode* Construct(vector<int>& pre, vector<int>& vin, int spre, int epre, int svin, int evin){
        int rootval = pre[spre];
        TreeNode* root = new TreeNode(rootval);
        if(spre == epre) return root;
        int vinroot = svin;
        while(vin[vinroot] != rootval){
            vinroot++;
        }
        int leftlength = vinroot - svin;
        if(leftlength > 0){
            root->left = Construct(pre, vin, spre+1, spre+leftlength, svin, vinroot-1);
        }
        int rightlength = evin - vinroot;
        if(rightlength > 0){
            root->right = Construct(pre, vin, spre+leftlength+1, epre, vinroot+1, evin);
        }
        return root;
    }
};