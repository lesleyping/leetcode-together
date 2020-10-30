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
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode pCur = pHead;
        ListNode pPre = null;
        while(pCur != null){
            ListNode pNxt = pCur.next;
            if(pNxt != null && pCur.val == pNxt.val){
                ListNode pTmp = pNxt;
                int val = pCur.val;
                while(pTmp != null && pTmp.val == val){
                    pTmp = pTmp.next;
                }
                if(pPre != null){
                    pPre.next = pTmp;
                }else{
                    pHead = pTmp;
                }
                pCur = pTmp;
            }else{
                pPre = pCur;
                pCur = pCur.next;
            }
        }
        return pHead;
    }
}