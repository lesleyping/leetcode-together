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
class Solution1 {
public:
    bool isSymmetrical(TreeNode* pRoot)
    {
        return isSymmetricalCore(pRoot, pRoot);
    }
    bool isSymmetricalCore(TreeNode* pRoot1, TreeNode* pRoot2){
        if (pRoot1 == nullptr && pRoot2 == nullptr)
            return true;
        if (pRoot1 == nullptr || pRoot2 == nullptr)
            return false;
        if (pRoot1->val != pRoot2->val)
            return false;
        return isSymmetricalCore(pRoot1->left, pRoot2->right) && 
            isSymmetricalCore(pRoot1->right, pRoot2->left);
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
};
*/
class Solution2 {
public:
    bool isSymmetrical(TreeNode* pRoot)
    {
        if (pRoot == nullptr)
            return true;
        stack<TreeNode*> stackNode;
        stackNode.push(pRoot->left);
        stackNode.push(pRoot->right);
        while (!stackNode.empty()){
            TreeNode* right = stackNode.top();
            stackNode.pop();
            TreeNode* left = stackNode.top();
            stackNode.pop();
            if (left == nullptr && right == nullptr)
                continue;                              //!!!!!!!
            if (left == nullptr || right == nullptr)
                return false;
            if (left->val != right->val)
                return false;
            stackNode.push(left->left);
            stackNode.push(right->right);
            stackNode.push(right->left);
            stackNode.push(left->right);
        }
        return true;
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
};
*/
class Solution {
public:
    bool isSymmetrical(TreeNode* pRoot)
    {
        if (pRoot == nullptr)
            return true;
        queue<TreeNode*> queueNode;
        queueNode.push(pRoot->left);
        queueNode.push(pRoot->right);
        while (!queueNode.empty()){
            TreeNode* left = queueNode.front();
            queueNode.pop();
            TreeNode* right = queueNode.front();
            queueNode.pop();
            if (left == nullptr && right == nullptr)
                continue;
            if (left == nullptr || right == nullptr)
                return false;
            if (left->val != right->val)
                return false;
            queueNode.push(left->left);
            queueNode.push(right->right);
            queueNode.push(right->left);
            queueNode.push(left->right);
        }
        return true;
    }
};