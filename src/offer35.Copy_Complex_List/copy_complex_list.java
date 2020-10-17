/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = pHead;
        while(cur != null){
            if(cur.random !=null){                        //!!!!!!!!!!!!!!
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode newHead = cur.next;
        RandomListNode tmp = newHead;
        while(tmp != null){
            cur.next = cur.next.next;
            if(tmp.next != null){                          //!!!!!!!!!!!!!!!!
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
            cur = cur.next;
        }
        return newHead;
    }
}

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode tmp = pHead;
        while(tmp != null){
            map.put(tmp, new RandomListNode(tmp.label));
            tmp = tmp.next;
        }
        tmp = pHead;
        while(tmp != null){
            if(tmp.next != null){
                map.get(tmp).next = map.get(tmp.next);
            }
            if(tmp.random != null){
                map.get(tmp).random = map.get(tmp.random);
            }
            tmp = tmp.next;
        }
        return map.get(pHead);
    }
}

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        return dfs(pHead, map);
    }
    private RandomListNode dfs(RandomListNode node, HashMap<RandomListNode, RandomListNode> map){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        RandomListNode newnode = new RandomListNode(node.label);
        map.put(node, newnode);
        map.get(node).next = dfs(node.next, map);                    //!!!!!!!!!!!!
        map.get(node).random = dfs(node.random, map);                 //!!!!!!!!!!!!
        return newnode;
    }
}

//
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        Queue<RandomListNode> q = new LinkedList<>();
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(pHead, new RandomListNode(pHead.label));
        q.offer(pHead);
        while(!q.isEmpty()){
            int len = q.size();
            while(len > 0){
                RandomListNode cur = q.poll();
                if(cur.next != null){
                    if(!map.containsKey(cur.next)){
                        map.put(cur.next, new RandomListNode(cur.next.label));
                        q.offer(cur.next);
                    }
                    map.get(cur).next = map.get(cur.next);
                }
                if(cur.random != null){
                    if(!map.containsKey(cur.random)){
                        map.put(cur.random, new RandomListNode(cur.random.label));
                        q.offer(cur.random);
                    }
                    map.get(cur).random = map.get(cur.random);
                }
                len--;
            }
        }
        return map.get(pHead);
    }
}