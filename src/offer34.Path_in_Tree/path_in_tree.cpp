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
    vector<vector<int> > res;
    vector<int> path;
    void find(TreeNode* root, int sum){
        if (root == nullptr) return;
        path.push_back(root->val);
        sum -= root->val;
        if (sum == 0 && !root->left && !root->right){
            res.push_back(path);
        }
        else{
            if (root->left)
                find(root->left, sum);
            if (root->right)
                find(root->right, sum);
        }
        path.pop_back();
    }
    vector<vector<int> > FindPath(TreeNode* root,int expectNumber) {
        
        find(root, expectNumber);
        return res;
    }
};