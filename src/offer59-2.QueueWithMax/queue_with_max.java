class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        return queue.isEmpty() ? -1 : max.peek();
    }
    
    public void push_back(int value) {
        queue.addLast(value);
        while(!max.isEmpty() && max.getLast() < value){
            max.removeLast();
        }
        max.add(value);
    }
    
    public int pop_front() {
        if(!max.isEmpty() && queue.peek().equals(max.getFirst())){
            max.removeFirst();
        }
        return queue.isEmpty() ? -1 : queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */