/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){ // !!!!!!!!!!
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(k > 1){
            if(fast.next == null){
                return null;         //!!!!!!!!!!!!!!!!
            }
            fast = fast.next;
            k--;
        }
        while(fast != null){
            if(fast.next == null){
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}