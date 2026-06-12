class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;

        int maxProfit = 0;

        while (end < prices.length) {
            if (prices[start] > prices[end]) {
                start = end;
            } else {
                maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
            }
            end++;
        }
        return maxProfit;
    }
}
