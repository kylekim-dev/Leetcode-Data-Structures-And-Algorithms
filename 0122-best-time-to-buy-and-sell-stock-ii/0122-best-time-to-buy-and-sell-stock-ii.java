class Solution {
    /*
        1. b - a가 증가추세이면 a를 고정시키고 b를 계속 증가시켜주면서 수익의 극대화를 구함
        2. 증가추세가 꺽이면 b - a를 sum += 기존 최고 수익, 기존 최고 수익 = 0, a = curr, 1번 실행
    */
    
    public int maxProfit(int[] prices) {        
        int l = 0, r = 1;
        int maxProfit = 0;

        while(r < prices.length){
            if(prices[r - 1] >= prices[r]){ // sell
                maxProfit += prices[r - 1] - prices[l];
                l = r;
            }
            r++;
        }

        if(prices[r - 1] - prices[l] > 0) maxProfit += prices[r - 1] - prices[l];
        
        return maxProfit;
    }
}