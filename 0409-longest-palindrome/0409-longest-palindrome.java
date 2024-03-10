class Solution {
    public int longestPalindrome(String s) {
        /*
         * Algorithms & DS: #Greedy
         * Time: O(N), Extra Space: O(N)
         */

        int max = 0;
        int[] map = new int[58];
        
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'A']++;
        }

        boolean hasOdd = false;

        for(int cnt : map){
            if(cnt % 2 == 1) {
                cnt -= 1;
                hasOdd = true;   
            } 
            max += cnt;
        }
        
        if(hasOdd) max += 1;
        
        return max;
    }
}