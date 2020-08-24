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
    TreeNode* Convert(TreeNode* pRootOfTree)
    {
        TreeNode *pLastNode = nullptr;
        ConvertCore(pRootOfTree, &pLastNode);
        TreeNode *pHeadNode = pLastNode;
        while (pHeadNode->left != nullptr && pHeadNode != nullptr)
            pHeadNode = pHeadNode->left;
        return pHeadNode;
    }
    void ConvertCore(TreeNode* pRootOfTree, TreeNode** pLastNode)
    {
        if (pRootOfTree == nullptr)
            return;
        TreeNode* cur = pRootOfTree;
        if (cur->left != nullptr)
            ConvertCore(cur->left, pLastNode);
        
        cur->left = *pLastNode;
        if (*pLastNode != nullptr)
            (*pLastNode)->right = cur;
        
        *pLastNode = cur;
        if (cur->right != nullptr)
            ConvertCore(cur->right, pLastNode);
    }
};