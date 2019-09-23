// @author npujcong@gmail.com(congjian)

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *p = l1;
		ListNode *q = l2;
		while(p->next != NULL || q->next != NULL) {
		  if(p->next == NULL) p->next = new ListNode(0);
		  if(q->next == NULL) q->next = new ListNode(0);
		  p = p->next;
		  q = q->next;
		}

		int remainder = 0;
		int result = 0;
		ListNode *head = new ListNode(0);
		ListNode *r = head;
        ListNode *rpre = head;

		p = l1;
		q = l2;
        int a1;
		while(p != NULL || result != 0){
            if( p != NULL){
                a1 = p->val + q->val + result;
                p = p->next;
			    q = q->next;
            }
            else
              a1 = result;
            
			remainder = a1%10;
			result = a1/10;
			
            if(r == NULL) {
              r = new ListNode(remainder);
              rpre->next = r;
            }
            else
             r->val = remainder;
            rpre = r;
			r = r->next;
		}
	    return head;
    }
};

