class Solution {
    public int maxProfit(int[] prices) {
        // Algorithm & DS: Sliding Window
        // Time: O(n), Extra Space: O(1)
        
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
}