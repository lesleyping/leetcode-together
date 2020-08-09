/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution1 {
public:
    void Mirror(TreeNode *pRoot) {
        if (pRoot == nullptr)
            return ;
        if (pRoot->left == nullptr && pRoot->right == nullptr)
            return;
        TreeNode* tmp = pRoot->left;
        pRoot->left = pRoot->right;
        pRoot->right = tmp;
        if (pRoot->left)
            Mirror(pRoot->left);
        if (pRoot->right)
            Mirror(pRoot->right);
    }
};

/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution2 {
public:
    void Mirror(TreeNode *pRoot) {
        if (pRoot == nullptr)
            return ;
        if (pRoot->left == nullptr && pRoot->right == nullptr)
            return;
       stack<TreeNode*> stackNode;
       stackNode.push(pRoot);
        while(!stackNode.empty()){
            TreeNode* ptmp = stackNode.top();
            stackNode.pop();
            if (ptmp->left || ptmp->right){
                TreeNode* tmp = ptmp->left;
                ptmp->left = ptmp->right;
                ptmp->right = tmp;
            }
            if (ptmp->left)
                stackNode.push(ptmp->left);
            if (ptmp->right)
                stackNode.push(ptmp->right);
        }
    }
};