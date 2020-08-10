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
            queue<TreeNode*> que;
            que.push(pRoot);
            int nextlevel = 0;
            int tobeprint = 1;
            while (!que.empty()){
                vector<int> r;
                int len = que.size();
                while(len--){
                    TreeNode* tmp = que.front();
                    r.push_back(tmp->val);
                    if (tmp->left) que.push(tmp->left);
                    if (tmp->right) que.push(tmp->right);
                    que.pop();
                }
                res.push_back(r);
            }
            return res;
        }
    
};