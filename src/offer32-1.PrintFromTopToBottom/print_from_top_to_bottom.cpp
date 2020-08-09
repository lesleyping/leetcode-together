/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution {
public:
    vector<int> PrintFromTopToBottom(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) return res;
        queue<TreeNode*> que;
        que.push(root);
        while(!que.empty()){
            TreeNode* tmp = que.front();
            res.push_back(tmp->val);
            que.pop();
            if (tmp->left)
                que.push(tmp->left);
            if (tmp->right)
                que.push(tmp->right);
        }
        return res;
    }
};