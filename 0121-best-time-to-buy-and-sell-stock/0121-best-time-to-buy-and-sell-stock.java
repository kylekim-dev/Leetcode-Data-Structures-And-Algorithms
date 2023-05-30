class Solution {
    /*
        Buy (*):  Sell보다 왼쪽에 위치하며 배열 내 가장 [작은] 숫자
        Sell($): Buy보다 오른쪽에 위치하며 배열 내 가장 [큰] 숫자
           
           *     $
        [7,1,5,3,6,4]
        
        buy     sell    total   maxProfit
        7       1       -6      0
        1       5       4       4
        1       3       2       4
        1       6       5       5
        1       4       3       5
    */
    public int maxProfit(int[] prices) {
        // Algorithm: DP, Time: O(N), Space: O(1)
        int maxProfit = 0;
        int buy = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        
        return maxProfit;
    }
}