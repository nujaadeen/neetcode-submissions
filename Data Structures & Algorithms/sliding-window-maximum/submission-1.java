class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int[] result = new int[(nums.length+1) - k];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int end = 0; end < nums.length; end++) {
            pq.offer(new int[]{end, nums[end]});

            if (end-start+1 == k) {
                while(pq.peek()[0] < start) {
                    pq.poll();
                }

                result[end+1-k] = pq.peek()[1];
                start++;
            }
        }

        return result;
    }
}
