class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        s, e = 0, 1
        maxProfit = 0

        while e < len(prices):
            maxProfit = max(maxProfit , prices[e] - prices[s])
            if prices[s] > prices[e]:
                s = e
            e += 1
        return maxProfit



        