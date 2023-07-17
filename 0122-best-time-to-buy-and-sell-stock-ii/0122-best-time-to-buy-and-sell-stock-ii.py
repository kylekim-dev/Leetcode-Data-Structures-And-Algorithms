class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        Algorithm & DS: Greedy
        Time: O(N), Space: O(1)
        """
        maxProfit = 0

        for i in range(1, len(prices)):
            if prices[i - 1] < prices[i]:
                maxProfit += prices[i] - prices[i - 1]

        return maxProfit
        