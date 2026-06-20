class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int r_index = stack.pop()[0];
                result[r_index] = i - r_index;
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return result;
    }
}
