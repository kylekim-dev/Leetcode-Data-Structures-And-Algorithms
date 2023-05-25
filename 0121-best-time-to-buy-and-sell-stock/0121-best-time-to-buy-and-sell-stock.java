class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prevMaxPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            if(maxProfit < prices[i] - prevMaxPrice) maxProfit = prices[i] - prevMaxPrice;
            if(prices[i] < prevMaxPrice) prevMaxPrice = prices[i];
        }
        
        return maxProfit;
    }
}