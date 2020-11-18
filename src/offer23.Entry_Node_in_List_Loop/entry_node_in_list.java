/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        boolean flag = false;
        ListNode p1 = pHead, p2 = pHead;
        while(p1.next != null && p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
            if(p1 == p2){
                flag = true;
                break;
            }
        }
        if(!flag){
            return null;
        }
        int len = 0;
        do{
            len++;
            p2 = p2.next;
        }while(p1 != p2);
        p1 = pHead;
        p2 = pHead;
        while(len > 0){
            p1 = p1.next;
            len--;
        }
        
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

//对临界条件的把握
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode p1 = pHead, p2 = pHead;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
            if(p1 == p2){
                break;
            }
        }
        if(p2 == null || p2.next == null){
            return null;
        }
        int len = 0;
        do{
            len++;
            p2 = p2.next;
        }while(p1 != p2);
        p1 = pHead;
        p2 = pHead;
        while(len > 0){
            p1 = p1.next;
            len--;
        }
        
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
//直接移位fast到开始节点，因为相遇点

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        fast = pHead;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}