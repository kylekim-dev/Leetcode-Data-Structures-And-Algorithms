class Solution {
    /*
        예제 케이스
         0 1 2 3 4 5
        [7,1,5,3,6,4]

        l   r
        0   1   sell: 7 - 7 = 0 // 0
        1   2   x
        1   3   sell: 5 - 1 = 4 // 0 + 4
        3   4
        3   5   sell: 6 - 3 = 3 // 7 <<
        5   6
         0 1 2 3 4
        [1,2,3,4,5]

        l   r
        1   2
        1   3
        1   4
        1   5
            
        Algorithm & DS: Two Pointer
        Time: O(N), Space: O(1)
        
        전략
        (저점에 사서 고점에 팔기를 반복해라!)
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