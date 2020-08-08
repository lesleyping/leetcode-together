/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};
*/
class Solution {
public:
    ListNode* deleteDuplication(ListNode* pHead)
    {
        if (pHead == nullptr || pHead->next == nullptr) return pHead;
        ListNode* newHead = new ListNode(-1);
        newHead->next = pHead;
        ListNode* pre = newHead;
        ListNode* cur = pHead;
        ListNode* next = nullptr;
        while (cur != nullptr && cur->next != nullptr){
            next = cur->next;
            if (cur->val == next->val){
                while (next != nullptr && next->val == cur->val){
                    delete cur;
                    cur = next;
                    next = next->next;
                }
                delete cur;
                cur = next;
                pre->next = cur;
            }
            else{
                pre = cur;
                cur = cur->next;
            }
        }
        return newHead->next;
    }
};