/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
*/
class Solution1 {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        stack<int> st;
        vector<int> res;
        ListNode* pNode = head;
        while(pNode != nullptr){
            st.push(pNode->val);
            pNode = pNode->next;
        }
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }
        return res;
    }
};

/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
*/
class Solution2 {
public:
    vector<int> res;
    vector<int> printListFromTailToHead(ListNode* head) {
        ListNode* pNode = head;
        dfs(pNode);
        return res;
    }
    void dfs(ListNode* head){
        if(head != nullptr){
            if(head->next != nullptr){
                dfs(head->next);
            }
            res.push_back(head->val);
        }
    }
};