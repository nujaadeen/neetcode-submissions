class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int max = 0;
        int width = heights.length - 1;

        while (left < right) {
            if (heights[left] < heights[right]) {
                max = Math.max(max, heights[left] * width);
                left++;
            } else {
                max = Math.max(max, heights[right] * width);
                right--;
            }
            width--;
        }
        return max;
    }
}
