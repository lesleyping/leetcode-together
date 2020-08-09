class Solution1 {
public:
    stack<int> m_data;
    stack<int> m_min;
    void push(int value) {
        m_data.push(value);
        if(m_min.size() == 0 || value < m_min.top()){
            m_min.push(value);
        }
        else{
            m_min.push(m_min.top());
        }
    }
    void pop() {
        m_data.pop();
        m_min.pop();
    }
    int top() {
        return m_data.top();
    }
    int min() {
        return m_min.top();
    }
};

class Solution2 {
public:
    int min_data = INT_MAX;
    stack<int> sta;
    void push(int value) {
        if (value < min_data){
            sta.push(min_data);
            min_data = value;
        }
        sta.push(value);
    }
    void pop() {
        if (sta.top() == min_data){
            sta.pop();
            min_data = sta.top();
            sta.pop();
        }
        else{
            sta.pop();
        }
    }
    int top() {
        return sta.top();
    }
    int min() {
        return min_data;
    }
};

class Solution3 {
public:
    class Node{
    public:
        int value;
        int min;
        Node* next;
        Node(int x, int min):value(x), min(min),next(nullptr) {}
    };
    Node* head;
    
    void push(int value) {
        if (head == nullptr){
            head = new Node(value, value);
        }
        else{
            Node* node;
            if (value < head->min){
                node = new Node(value, value);
            }
            else{
                node = new Node(value, head->value);
            }
            node->next = head;
            head = node;
        }
    }
    void pop() {
        Node* del = head;
        head = head->next;
        delete del;
    }
    int top() {
        return head->value;
    }
    int min() {
        return head->min;
    }
};