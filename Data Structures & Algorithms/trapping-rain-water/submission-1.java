class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        left++;
        right--;

        int total = 0;

        while (left <= right) {
            if (maxLeft < maxRight) {
                int area = maxLeft - height[left];

                if (area >= 0) total += area;
                maxLeft = Math.max(maxLeft, height[left]);
                left++;

            } else {
                int area = maxRight - height[right];

                if (area >= 0) total += area;
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
            
        }
        return total;
    }
}
