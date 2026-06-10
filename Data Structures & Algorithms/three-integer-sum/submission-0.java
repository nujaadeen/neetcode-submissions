class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        int[] sortedNums = mergeSort(nums);

        for(int i = 0; i < sortedNums.length; i++) {
            int target = -sortedNums[i];

            int left = i + 1;
            int right = sortedNums.length -1;

            while(left < right) {
                int leftInt = sortedNums[left];
                int rightInt = sortedNums[right];

                if (target == leftInt + rightInt) {
                    resultSet.add(new ArrayList<>(List.of(-target, leftInt, rightInt)));
                }
                
                if (target > leftInt + rightInt) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        } 

        int mid = nums.length / 2;

        int[] leftArr = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        int lPtr = 0;
        int rPtr = 0;

        int[] result = new int[nums.length];

        int resultPtr = 0;

        while(lPtr < leftArr.length && rPtr < rightArr.length) {
            if (leftArr[lPtr] < rightArr[rPtr]) {
                result[resultPtr] = leftArr[lPtr];
                resultPtr++;
                lPtr++;
            } else {
                result[resultPtr] = rightArr[rPtr];
                resultPtr++;
                rPtr++;
            }
        }

        while(lPtr < leftArr.length) {
            result[resultPtr] = leftArr[lPtr];
            resultPtr++;
            lPtr++;
        }

        while(rPtr < rightArr.length) {
            result[resultPtr] = rightArr[rPtr];
            resultPtr++;
            rPtr++;
        }

        return result;
    }
}
