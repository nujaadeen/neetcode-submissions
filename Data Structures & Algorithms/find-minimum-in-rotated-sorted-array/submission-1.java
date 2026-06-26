class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        int min = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            int mid = (r - l) / 2 + l;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }
        return min;
    }
}
