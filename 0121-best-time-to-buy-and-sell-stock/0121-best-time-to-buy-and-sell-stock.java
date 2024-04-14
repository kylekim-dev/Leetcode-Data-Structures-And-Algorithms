class Solution {
    public int maxProfit(int[] prices) {
        /*
         * Algorithms & DS: #DP
         * Time: O(N), Extra Space: O(1)
         */

        int maxProfit = 0;
        int minPrice = prices[0];

        for(int currPrice : prices){
            maxProfit = Math.max(currPrice - minPrice, maxProfit);
            minPrice = Math.min(minPrice, currPrice); 
        }
        
        return maxProfit;
    }
}