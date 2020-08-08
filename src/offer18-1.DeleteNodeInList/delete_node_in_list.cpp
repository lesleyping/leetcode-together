/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution1 {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        ListNode* root = head;
        if(root->val == val) return head->next;
        while(head->next){
            if (head->next->val == val){
                head->next = head->next->next;
            }
            else{
                head = head->next;
            }
        }
        return root;
    }
};

////////////////////////
void DeleteNode(ListNode** pListHead, ListNode* pToBeDeleted)
{
    if (!pListHead || !pToBeDeleted)
        return;

    // 要删除的结点不是尾结点
    if (pToBeDeleted->m_pNext != nullptr)
    {
        ListNode* pNext = pToBeDeleted->m_pNext;
        pToBeDeleted->m_nValue = pNext->m_nValue;
        pToBeDeleted->m_pNext = pNext->m_pNext;

        delete pNext;
        pNext = nullptr;
    }
    // 链表只有一个结点，删除头结点（也是尾结点）
    else if (*pListHead == pToBeDeleted)
    {
        delete pToBeDeleted;
        pToBeDeleted = nullptr;
        *pListHead = nullptr;
    }
    // 链表中有多个结点，删除尾结点
    else
    {
        ListNode* pNode = *pListHead;
        while (pNode->m_pNext != pToBeDeleted)
        {
            pNode = pNode->m_pNext;
        }

        pNode->m_pNext = nullptr;
        delete pToBeDeleted;
        pToBeDeleted = nullptr;
    }
}