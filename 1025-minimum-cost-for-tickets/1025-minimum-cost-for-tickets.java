class Solution {
    /*
          x     x   x x x                                  x
        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        0 2 2 2 4 4 6 7 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 11
    */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1]; // 각 일별로 최소 코스트를 저장할 배열 생성
        int dayIdx = 0;

        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i - 1];
            if(i == days[dayIdx]){
                int cost = dp[i] + costs[0];
                cost = Math.min(cost, dp[Math.max(i - 7, 0)] + costs[1]);
                cost = Math.min(cost, dp[Math.max(i - 30, 0)] + costs[2]);

                dp[i] = cost;
                dayIdx++;
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[dp.length - 1];        
    }
}