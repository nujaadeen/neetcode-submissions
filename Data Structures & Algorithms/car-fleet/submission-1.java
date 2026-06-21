class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        Integer[] order = new Integer[position.length];

        for (int i = 0; i < position.length; i++) {
            order[i] = i;
        }

        Arrays.sort(
            order,
            (a, b) -> Integer.compare(position[b], position[a])
        );

        for (int j = 0; j < order.length; j++) {
            double time = (double) (target - position[order[j]]) / speed[order[j]];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
