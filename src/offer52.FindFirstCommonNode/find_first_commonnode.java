//1
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != p2){
            if(p1 == null){
                p1 = pHead2;
            }else if(p2 == null){
                p2 = pHead1;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1;
    }
}
//2
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1, p2 = pHead2;
        int len1 = 0, len2 = 0;
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 != null){
            len2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(len1 > len2){
            int tmp = len1 - len2;
            while(tmp > 0){
                p1 = p1.next;
                tmp--;
            }
        }else{
            int tmp = len2 - len1;
            while(tmp > 0){
                p2 = p2.next;
                tmp--;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

//------second
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
