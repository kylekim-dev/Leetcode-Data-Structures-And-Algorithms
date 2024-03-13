class Solution {
    public int climbStairs(int n) {
        /*
         * Algorithms & DS: #DP
         * Time: O(N), Extra Space: O(1)
            1 = 1
            2 = 2
            3 = 3
            4 = 5
            5 = 8
        */
        int p = 1, curr = 1;
        
        for(int i = 1; i < n; i++){
            int temp = curr;
            curr = curr + p;
            p = temp;
        }
        
        return curr;
    }
}