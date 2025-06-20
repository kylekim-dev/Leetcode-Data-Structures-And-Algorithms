class Solution {
    public boolean isAnagram(String s, String t) {
        /*
         * Algorithms & Data Structure: HashSet
         * Time Complexity:  O(N)
         * Space Complexity: O(1) = 26
         */

         int[] map = new int[27];

         for(char c : s.toCharArray()){
            map[c - 'a'] += 1;
         }

         for(char c : t.toCharArray()){
            map[c - 'a'] -= 1;

            if(map[c - 'a'] < 0){
                return false;
            }
         }

         for(int val : map){
            if(val > 0){
                return false;
            }
         }

         return true;
    }
}