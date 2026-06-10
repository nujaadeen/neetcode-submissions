class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] sortedNums = mergeSort(nums);

        for(int i = 0; i < sortedNums.length - 2; i++) {
            if (i > 0 && sortedNums[i] == sortedNums[i-1]) continue;

            int left = i + 1;
            int right = sortedNums.length -1;

            while(left < right) {
                int sum = sortedNums[i] + sortedNums[left] + sortedNums[right];

                if (sum == 0) {
                    result.add(new ArrayList<>(List.of(sortedNums[i], sortedNums[left], sortedNums[right])));

                    left++;

                    while (left < right && sortedNums[left] == sortedNums[left-1]) left++;
                }
                
                if (sum < 0) left++;
                if (sum > 0) right--;
            }
        }

        return result;
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
