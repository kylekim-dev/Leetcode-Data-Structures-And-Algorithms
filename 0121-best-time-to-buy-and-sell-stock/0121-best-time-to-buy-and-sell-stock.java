class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prevMaxPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - prevMaxPrice);
            prevMaxPrice = Math.min(prevMaxPrice, prices[i]);
        }
        
        return maxProfit;
    }
}