class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        if (nums.length == 0) return 0;

        int max = 1;
        for (int num : nums) {
            set.add(num);
        }

        for (int num: nums) {
            if (!set.contains(num-1)){
                int len = 1;
                int current = num;

                while (set.contains(current+1)){
                    len++;
                    current++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
