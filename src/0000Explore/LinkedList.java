//1-1
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false; 
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
//1-2 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false; 
        Set<ListNode> hash = new HashSet<>();
        ListNode cur = head;
        boolean found = false;
        while(cur != null){
            if(!hash.contains(cur)){
                hash.add(cur);
                cur = cur.next;
            }else{
                return true;
            }
        }
        return false;
    }
}
//2
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do{
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != slow);
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
//3
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            if(pa == null){
                pa = headB;
            }else if(pb == null){
                pb = headA;
            }else{
                pa = pa.next;
                pb = pb.next;
            }
        }
        return pa;
    }
}
//4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode fast = tmp;
        ListNode slow = tmp;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }
}
//5-1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
//5-2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
//6-1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode h = tmp;
        while(h.next != null){
            if(h.next.val == val){
                h.next = h.next.next;
            }else{
                h = h.next;
            }
    
        }
        return tmp.next;
    }
}
//6-2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}
//7
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddt = head;
        ListNode event = head.next;
        while(event != null && event.next != null){
            oddt.next = oddt.next.next;
            oddt = oddt.next;
            event.next = event.next.next;
            event = event.next;
        }
        oddt.next = even;
        return odd;
    }
}
//8
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode p = head, pre = null;
        while(fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;

            p.next = pre;
            pre = p;
        }

        if(fast != null){
            slow = slow.next;//跳过奇数时中间的数字
        }

        while(slow != null){
            if(slow.val != p.val){
                return false;
            }
            slow = slow.next;
            p = p.next;
        }
        return true;
    }
}
//9-1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode newnode = new ListNode(-1);
        ListNode save = newnode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode l = new ListNode(l1.val);
                newnode.next = l;
                l1 = l1.next;
            }else{
                ListNode l = new ListNode(l2.val);
                newnode.next = l;
                l2 = l2.next;
            }
            newnode = newnode.next;
        }
        if(l1 != null){
            newnode.next = l1;
        }
        if(l2 != null){
            newnode.next = l2;
        }
        return save.next;
    }
}
//9-2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//10
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode newnode = new ListNode(-1);
        ListNode save = newnode;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(carry){
                sum++;
            }
            newnode.next = new ListNode(sum%10);
            newnode = newnode.next;
            carry = sum > 9 ? true : false;
        }
        if(carry){
            newnode.next = new ListNode(1);
        }
        return save.next;
    }
}
//11-1
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while(cur != null){
            Node nxt = cur.next;
            if(cur.child != null){
                Node childNode = cur.child;
                cur.next = childNode;
                childNode.prev = cur;
                while(childNode != null && childNode.next != null){
                    childNode = childNode.next;
                }
                childNode.next = nxt;
                if(nxt != null) nxt.prev = childNode;
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
//11-2
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node pre = null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    public void dfs(Node head){
        if(head == null){
            return;
        }
        Node nxt = head.next;
        if(pre != null){
            pre.next = head;
            head.prev = pre;
        }
        pre = head;
        dfs(head.child);
        head.child = null;
        dfs(nxt);
    }
}
//12-1
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList(head.next);
        clone.random = copyRandomList(head.random);
        return clone;
    }
}
//12-2
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node clone = new Node(head.val);
        map.put(head, clone);
        q.offer(head);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.next != null && !map.containsKey(tmp.next)){
                Node nxt = new Node(tmp.next.val);
                q.offer(tmp.next);
                map.put(tmp.next, nxt);
            }
            if(tmp.random != null && !map.containsKey(tmp.random)){
                Node rand = new Node(tmp.random.val);
                q.offer(tmp.random);
                map.put(tmp.random, rand);
            }
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
        }
        return clone;
    }
}
//12-3
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

//12-4
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        for(Node p = head; p != null; p = p.next.next){
            Node newP = new Node(p.val);
            newP.next = p.next;//forget
            p.next = newP;
        }
        for(Node p = head; p != null; p = p.next.next){
            if(p.random != null){
                p.next.random = p.random.next;//wrong
            }else{
                p.next.random = null;
            }
        }
        Node node = head;
        Node clone = head.next;
        while(node.next!= null){
            Node tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }
        return clone;
    }
}
//13
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        cur.next = head;
        len = len - k%len - 1;
        cur = head;
        while(len > 0){
            len--;
            cur = cur.next;
        }
        ListNode t = cur.next;
        cur.next = null;
        return t;
    }
}