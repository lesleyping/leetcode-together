//1
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp != null){
            res.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.reverse(res);
        return res;
    }
}
//2
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res,listNode);
        return res;
    }
    public void dfs(ArrayList res, ListNode node){
        if(node != null){
            if(node.next != null){
                dfs(res,node.next);
            }
            res.add(node.val);
        }
    }
}