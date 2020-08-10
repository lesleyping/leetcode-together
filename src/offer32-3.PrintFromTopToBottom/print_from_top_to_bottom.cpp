/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/
class Solution {
public:
    vector<vector<int> > Print(TreeNode* pRoot) {
        vector<vector<int>> res;
        if (pRoot == nullptr) return res;
        stack<TreeNode*> sta1;
        stack<TreeNode*> sta2;
        sta1.push(pRoot);
        int len = 0;
        while (!sta1.empty() || !sta2.empty()){
            vector<int> r1, r2;
            while (!sta1.empty()){
                TreeNode* tmp = sta1.top();
                r1.push_back(tmp->val);
                if (tmp->left)
                    sta2.push(tmp->left);
                if (tmp->right)
                    sta2.push(tmp->right);
                sta1.pop();
            }
            if (r1.size()){
                res.push_back(r1);
            }
            while (!sta2.empty()){
                TreeNode* tmp = sta2.top();
                r2.push_back(tmp->val);
                
                if (tmp->right)
                    sta1.push(tmp->right);
                if (tmp->left)
                    sta1.push(tmp->left);
                sta2.pop();
            }
            if (r2.size())
                res.push_back(r2);
        }
        return res;
    }
    
};