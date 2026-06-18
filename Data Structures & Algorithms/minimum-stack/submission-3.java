class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int minVal = Math.min(
            val, 
            !minStack.isEmpty() ? minStack.peek() : val);

        minStack.push(minVal);
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
