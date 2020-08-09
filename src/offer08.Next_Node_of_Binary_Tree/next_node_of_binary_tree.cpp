/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {
        
    }
};
*/
class Solution {
public:
    TreeLinkNode* GetNext(TreeLinkNode* pNode)
    {
        if(pNode == nullptr) return nullptr;
        if(pNode->right != nullptr){
            pNode = pNode->right;
            while(pNode->left != nullptr){
                pNode = pNode->left;
            }
            return pNode;
        }
        while(pNode->next != nullptr){
            TreeLinkNode* nroot = pNode->next;
            if(nroot->left == pNode){
                return nroot;
            }
            pNode = pNode->next;
        }
        return nullptr;
    }
};