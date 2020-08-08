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
    ListNode* ReverseList(ListNode* pHead) {
        ListNode* pPrev = nullptr;
        ListNode* pNode = pHead;
        ListNode* pReversedHead = nullptr;
        while (pNode != nullptr){
            ListNode* pNext = pNode->next;
            if (pNext == nullptr)
                pReversedHead = pNode;
            pNode->next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
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
    ListNode* ReverseList(ListNode* pHead) {
        if (pHead->next == nullptr || pHead == nullptr){
            return pHead;
        }
        ListNode* pReversedNode = ReverseList(pHead->next);
        pHead->next->next = pHead;
        pHead->next = nullptr;
        return pReversedNode;
    }
};