class Solution {
    /*
         1 2 3 4 5 6 7 8
        [3,3,5,0,0,3,1,4]
        
        pq = 3 3
        
        low1 = 1
        low2 = 2
        
        
        0 1 2 3 4
    
    */
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length], right = new int[prices.length]; // array of left and right side max profit
        int min = prices[0];

        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];

        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        
        return maxProfit;
    }
}