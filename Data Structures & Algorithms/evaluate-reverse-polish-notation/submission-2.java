class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        Set<String> ops = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (ops.contains(token)) {
                int x = stack.pop();
                int y = stack.pop();

                stack.push(calculate(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int x, int y, String operation) {
        return switch (operation) {
            case "+" -> x + y;
            case "-" -> y - x;
            case "*" -> x * y;
            case "/" -> y / x;
            default -> throw new IllegalArgumentException(
                "Unknown operation: " + operation
            );
        };
    }
}
