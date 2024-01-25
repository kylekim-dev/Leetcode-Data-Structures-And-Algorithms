class Solution {
    public int fib(int n) {
        /*
            Data Structure & Algorithms: DP
            Time: O(N), extra space: O(N)
        */
        
        /*int[] dp = new int[n + 1];
        
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 1;
        
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }*/
        
        int prev = 0, answer = 0;
        
        if(n > 0) answer = 1;
        
        for(int i = 2; i <= n; i++){
            int temp = answer;
            answer = answer + prev;
            prev = temp;
        }
        
        return answer;
    }
}