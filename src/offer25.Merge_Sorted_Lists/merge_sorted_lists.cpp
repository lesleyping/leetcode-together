/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution1 {
public:
    ListNode* Merge(ListNode* pHead1, ListNode* pHead2)
    {
        if (pHead1 == nullptr)
            return pHead2;
        if (pHead2 == nullptr){
            return pHead1;
        }
        ListNode* mergeHead = nullptr;
        ListNode* cur = nullptr;
        while (pHead1 != nullptr && pHead2 != nullptr){
            if (pHead1->val <= pHead2->val){
                if (mergeHead == nullptr){
                    mergeHead = cur = pHead1;
                }
                else{
                    cur->next = pHead1;
                    cur = cur->next;
                }
                pHead1 = pHead1->next;
            }
            else{
                if (mergeHead == nullptr){
                    mergeHead = cur = pHead2;
                }
                else{
                    cur->next = pHead2;
                    cur = cur->next;
                }
                pHead2 = pHead2->next;
            }
        }
        if (pHead1 == nullptr){
            cur->next = pHead2;
        }
        else {
            cur->next = pHead1;
        }
        return mergeHead;
    }
};

/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution2 {
public:
    ListNode* Merge(ListNode* pHead1, ListNode* pHead2)
    {
        if (pHead1 == nullptr)
            return pHead2;
        if (pHead2 == nullptr){
            return pHead1;
        }
        ListNode* pMergedHead = nullptr;
        if (pHead1->val < pHead2->val){
            pMergedHead = pHead1;
            pMergedHead->next = Merge(pHead1->next, pHead2);
        }
        else{
            pMergedHead = pHead2;
            pMergedHead->next = Merge(pHead1, pHead2->next);
        }
        return pMergedHead;
    }
};