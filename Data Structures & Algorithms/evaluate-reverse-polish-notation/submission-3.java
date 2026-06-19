class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> 
                    stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y-x);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
