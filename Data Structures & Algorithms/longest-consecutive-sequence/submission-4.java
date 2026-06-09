class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num: set) {
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
