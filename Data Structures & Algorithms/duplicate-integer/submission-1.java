class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique_nums = new HashSet<>(); 
        for(int num : nums){
            if(unique_nums.contains(num)){
                return true;
            }
            unique_nums.add(num);
        }
        return false;
    }
}