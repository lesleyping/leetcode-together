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
    ListNode* EntryNodeOfLoop(ListNode* pHead)
    {
        if (pHead == nullptr) return nullptr;
        ListNode* pslow = pHead;
        ListNode* pfast = pHead;
        bool flag = false;
        while (pslow -> next != nullptr && pfast -> next != nullptr && pfast->next->next != nullptr){
            pslow = pslow->next;
            pfast = pfast->next;
            pfast = pfast->next;
            if (pfast == pslow){
                flag = true;
                break;
            }
        }
        if (!flag) return nullptr;
        int loop = 1;
        while (pslow->next != pfast){
            pslow = pslow->next;
            loop++;
        }
        pfast = pHead;
        pslow = pHead;
        for (int i = 0; i < loop; i++){
            pfast = pfast->next;
        }
        while (pfast != pslow){
            pfast = pfast->next;
            pslow = pslow->next;
        }
        return pslow;
    }
};