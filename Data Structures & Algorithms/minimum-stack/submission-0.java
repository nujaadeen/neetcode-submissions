class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val < minStack.peek()){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
