class Solution {
    public int countGoodSubstrings(String s) {
        /*
         * Algorithms & DS: #Sliding Window
         * Time: O(N), Extra Space: O(1)
         */

        int[] checker = new int[26];
        int ans = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            int rightValue = s.charAt(r) - 'a';

            checker[rightValue]++;

            while (r - l > 2 || checker[rightValue] >= 2) {
                checker[s.charAt(l) - 'a']--;
                l++;
            }

            if(r - l == 2) 
                ans++;
            
            r++;
        }
        
        return ans;
    }
}