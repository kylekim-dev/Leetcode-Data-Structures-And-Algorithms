class Solution {
    public int fib(int n) {
        // Algorithm: DP Memoization (Bottom-Up)
        // Time: O(N), Space: O(N)
        if (n < 2) return n;
        
        int a = 0, b = 1;
        int temp;
        
        for(int i = 2; i <= n; i++){
            temp = b;
            b = a + b;
            a = temp;
        }
        
        return b;
    }
}