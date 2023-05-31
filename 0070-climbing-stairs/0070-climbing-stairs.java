class Solution {
    /*
        n = 1, // 1
        n = 2, // 2
        n = 3, // 3
        n = 4, // 5
        n = 5, // 8
        n = 6, // 13

        피보나치 규칙
        
    */
    public int climbStairs(int n) {
        // Algorithm: DP
        // Time: O(N), Space: O(1)
        int prev = 0, curr = 1;
        
        for(int i = 0; i < n; i++){
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        
        return curr;
    }
}