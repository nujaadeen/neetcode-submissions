class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        if (nums.length == 0) return 0;

        int max = 1;
        for (int num : nums) {
            set.add(num);
        }

        for (int num: nums) {
            int len = 1;
            int temp = num;

            while (set.contains(temp+1)){
                len += 1;
                temp += 1;
            }
            if (len > max) max = len;
        }

        return max;
    }
}
