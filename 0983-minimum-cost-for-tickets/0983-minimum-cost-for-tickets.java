class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        /*
            Algorithms & DS: #DP, #Memoezation
            Time: O(N), Extra Space: O(N)
            N: lastest travel day
         */

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        int i = 0;

        for(int day = 1; day < lastDay + 1; day++){

            if(days[i] == day){
                int minCost = Integer.MAX_VALUE;

                if(day >= 1) minCost = Math.min(dp[day - 1] + costs[0], minCost);
                else minCost = Math.min(dp[0] + costs[0], minCost);

                if(day >= 7) minCost = Math.min(dp[day - 7] + costs[1], minCost);
                else minCost = Math.min(dp[0] + costs[1], minCost);

                if(day >= 30) minCost = Math.min(dp[day - 30] + costs[2], minCost);
                else minCost = Math.min(dp[0] + costs[2], minCost);

                dp[day] = minCost;
                i++;
            }
            else {
                dp[day] = dp[day - 1];
            }
        }

        return dp[lastDay];
    }
}