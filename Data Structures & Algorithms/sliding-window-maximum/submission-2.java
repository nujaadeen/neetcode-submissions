class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int[] result = new int[(nums.length+1) - k];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int end = 0; end < nums.length; end++) {
            while (!deque.isEmpty() && nums[end] > nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(end);

            if (end-start+1 == k) {
                while (start > deque.peekFirst()) {
                    deque.removeFirst();
                }

                result[end+1-k] = nums[deque.peekFirst()];
                start++;
            }
        }

        return result;
    }
}
