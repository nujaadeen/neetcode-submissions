class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;
        for (int j = 1; j < nums.length; j++) {
            output[j] = output[j-1] * nums[j-1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            output[i] = output[i] * right;
            right *= nums[i]; 
        }

        return output;
    }
}  
