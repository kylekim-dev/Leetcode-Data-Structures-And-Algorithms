class Solution {
    public boolean isIsomorphic(String s, String t) {
        /*
         * Algorithms & DS: HashMap
         * Time: O(N), Extra Space: O(M)
         */

        int[] map1 = new int[128];
        int[] map2 = new int[128];

        for(int i = 0; i < s.length(); i++){
            int s1 = s.charAt(i), t1 = t.charAt(i);

            if(map1[s1] == 0){
                map1[s1] = t1;
            }

            if(map1[s1] != t1){
                return false;
            }

            if(map2[t1] == 0){
                map2[t1] = s1;
            }

            if(map2[t1] != s1){
                return false;
            }
        }
        
        return true;
    }
}