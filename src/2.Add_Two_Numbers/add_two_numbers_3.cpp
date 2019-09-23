//good solution
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
    {
        // cout<<l1->val;
        // ListNode a(2);
        // cout<<a.val;
        ListNode *result, *p;
        result = new ListNode(0);
        p=result;
        int carry, sum;
        carry=0;
        while(l1||l2)
        {
            sum = ((l1)?l1->val:0) + ((l2)?l2->val:0) + carry;
            p->val=sum%10;
            carry=sum/10;
            if(l1) l1=l1->next;
            if(l2) l2=l2->next;
            if(l1||l2)
            {
                p->next=new ListNode(0);
                p=p->next;
            }
        }
        if(carry)
        {
            p->next=new ListNode(1);
        }
        return result;
    }
};