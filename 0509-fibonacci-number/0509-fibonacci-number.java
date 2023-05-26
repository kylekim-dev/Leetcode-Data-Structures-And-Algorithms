class Solution {
    public int fib(int n) {
        // Algorithm: DP(Bottom-Up)
        // Time: O(N), Space: O(N)
        if(n < 1) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length; i++) 
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }
}