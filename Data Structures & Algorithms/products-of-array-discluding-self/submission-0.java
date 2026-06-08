class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int j = 0; j < nums.length; j++){
            int prev = (j-1 >= 0) ? nums[j-1] : 1;
            int fwdAcc = map.getOrDefault(j-1, new ArrayList<>(List.of(1, 1))).get(0) * prev;
            map.put(j, new ArrayList<>(List.of(fwdAcc)));
        }

        for (int i = nums.length-1; i >= 0; i--){
            int prev = (i+1 < nums.length) ? nums[i+1] : 1;
            int revAcc = map.getOrDefault(i+1, new ArrayList<>(List.of(1, 1))).get(1) * prev;
            map.get(i).add(revAcc);
        }

        int acc = 1;
        for (int j = 0; j < nums.length; j++){
            output[j] = map.get(j).stream().reduce(1, (c, a) -> c*a);
        }
        return output;
    }
}  
