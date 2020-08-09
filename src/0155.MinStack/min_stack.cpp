class MinStack {
public:
    int min = INT_MAX;
    stack<int> s;
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        if(x <= min){
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    void pop() {
        if(s.top() == min){
            s.pop();
            min = s.top();
            s.pop();
        }
        else
            s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */


class MinStack {
private:
    class Node{
    public:
        int value;
        int min;
        Node* next;
        Node(int x, int min):value(x),min(min),next(nullptr) {}
    };
    Node* head;
public:
    /** initialize your data structure here. */
    MinStack() {
        head = nullptr;
    }
    
    void push(int x) {
        if(nullptr == head){
            head = new Node(x,x);
        }
        else{
            Node* node = new Node(x, min(x, head->min));
            node->next = head;
            head = node;
        }
    }
    
    void pop() {
        if(nullptr != head){
            Node* del = head;
            head = head->next;
            delete del;
        }
    }
    
    int top() {
        if(nullptr != head){
            return head->value;
        }
        return -1;
    }
    
    int getMin() {
        if(nullptr != head){
            return head->min;
        }
        return -1;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
