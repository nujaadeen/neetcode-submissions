class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int lastIndex = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] val = stack.pop();
                maxArea = Math.max(maxArea, (i - val[0]) * val[1]);
                lastIndex = val[0];
            }
            stack.push(new int[]{(lastIndex), heights[i]});
        }

        while (!stack.isEmpty()){
            int[] val = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - val[0]) * val[1]);
        }
        return maxArea;
    }
}
