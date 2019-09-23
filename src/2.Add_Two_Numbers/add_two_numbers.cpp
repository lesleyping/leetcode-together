//congjian
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
//good solution
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

//lxp
#include <iostream>
#include <stack>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x):val(x),next(NULL)	{}
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

		p = l1;
		q = l2;
		while(p != NULL){
			int a1 = p->val + q->val + result;
			remainder = a1%10;
			result = a1/10;
			r->val = remainder;
			p = p->next;
			q = q->next;
			if (p!=NULL){
				r->next = new ListNode(0);
				//cout << "r-value" << r->val << endl;
				r = r->next;
			}

		}
		if (result > 0)
		{
			r->next = new ListNode(result);
		}
	    return head;
	}

};

int main()
{
	ListNode* head1 = new ListNode(2);

	ListNode* pnode1 = new ListNode(4);
	head1->next=pnode1;

	ListNode* pnode2 = new ListNode(3);
	pnode1->next=pnode2;

	pnode2->next = NULL;

	ListNode* head2 = new ListNode(5);

	ListNode* qnode1 = new ListNode(6);
	head2->next=qnode1;

	ListNode* qnode2 = new ListNode(4);
	qnode1->next=qnode2;

	//ListNode* qnode3 = new ListNode(8);
	//qnode2->next=qnode3;

	qnode2->next = NULL;

	Solution A;
	ListNode *result = A.addTwoNumbers(head1, head2);
	while(result != NULL)
	{
	    cout << result->val << endl;
	    result = result->next;
	}

	return 0;
}
