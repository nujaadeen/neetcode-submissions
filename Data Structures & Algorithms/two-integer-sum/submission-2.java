class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx_map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int search_val = target - nums[i];
            if (idx_map.containsKey(search_val)){
                return new int[]{idx_map.get(search_val), i};
            }
            idx_map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
