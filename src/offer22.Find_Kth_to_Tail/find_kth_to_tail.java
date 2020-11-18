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

// 上面的版本是牛客的，最后一个while循环的判断可去掉
//下面这个也可以防止k大于链表长度
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
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
// 下面是lc的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}