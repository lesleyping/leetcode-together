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
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newlist = new ListNode(-1);
        ListNode head = newlist;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                newlist.next = new ListNode(list1.val);
                list1 = list1.next;
                newlist = newlist.next;
            }else{
                newlist.next = new ListNode(list2.val);
                list2 = list2.next;
                newlist = newlist.next;
            }
        }
        while(list1 != null){
            newlist.next = new ListNode(list1.val);
            list1 = list1.next;
            newlist = newlist.next;
        }
        
        while(list2 != null){
            newlist.next = new ListNode(list2.val);
            list2 = list2.next;
            newlist = newlist.next;
        }
        return head.next;
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergedNode = null;
        if(list1.val < list2.val){
            mergedNode = list1;
            mergedNode.next = Merge(list1.next, list2);
        }else{
            mergedNode = list2;
            mergedNode.next = Merge(list1, list2.next);
        }
        return mergedNode;
    }
}