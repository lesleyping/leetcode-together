/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if (pListHead == nullptr || k == 0) return nullptr;
        ListNode* node1 = pListHead;
        ListNode* node2 = pListHead;
        for (int i = 0; i < k - 1; i++){
            if (node1->next != nullptr){
                node1 = node1->next;
            }
            else
                return nullptr;
        }
        while (node1->next != nullptr){
            node1 = node1->next;
            node2 = node2->next;
        }
        return node2;
    }
};