class Solution {
    public int maxCoins(int[] piles) {

        /*
            Algorithms & DS: #Greedy, #Sorting
            Time: O(N * LogN), Extra Space: O(1)
         */

        Arrays.sort(piles);

        int ans = 0;
        int l = 0, r = piles.length - 1;

        while (l < r){
            ans += piles[r - 1];
            r -= 2;
            l += 1;
        }
        
        return ans;
    }
}