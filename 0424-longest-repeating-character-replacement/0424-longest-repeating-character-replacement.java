class Solution {
    public int characterReplacement(String s, int k) {
        /*
         * Algorithms & DS: #Sliding Window
         * Time: O(N), Extra Space: O(1)
         */

        int[] alphabetCount = new int[26];
        int max = 0;
        int l = 0, r = 0;
        int mostAlpha = 0;

        while (r < s.length()) {
            int rAlpha = s.charAt(r) - 'A';
            alphabetCount[rAlpha]++;

            if(alphabetCount[mostAlpha] < alphabetCount[rAlpha]){
                mostAlpha = rAlpha;
            }

            while (r - l + 1 > k + alphabetCount[mostAlpha]) {
                int lAlpha = s.charAt(l) - 'A';
                alphabetCount[lAlpha]--;
                l++;
                if(lAlpha == mostAlpha){
                    break;
                }
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        
        return max;
    }
}