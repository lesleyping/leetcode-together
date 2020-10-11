//1
import java.util.Stack;

public class Solution {
    Stack<Integer> numStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        numStack.push(node);
        if(minStack.size() == 0 || node < minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        minStack.pop();
        numStack.pop();
    }
    
    public int top() {
        return numStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
//2
import java.util.Stack;

public class Solution {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        if(node < min){
            stack.push(min);
            min = node;
        }
        stack.push(node);
    }
    
    public void pop() {
        int cur = stack.pop();
        if(cur == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min;
    }
}
//3
import java.util.Stack;

public class Solution {

    public class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    Node head;
    public void push(int node) {
        if(head == null){
            head = new Node(node, node);
        }else{
            Node cur;
            if(node < head.min){
                cur = new Node(node, node);
            }else{
                cur = new Node(node, head.min);
            }
            cur.next = head;
            head = cur;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int min() {
        return head.min;
    }
}