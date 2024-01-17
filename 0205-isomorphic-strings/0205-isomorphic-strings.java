class Solution {
    public boolean isIsomorphic(String s, String t) {
        /*
         * Algorithms & DS: HashMap
         * Time: O(N), Extra Space: O(M)
         */

         if(s.length() != t.length()){
            return false;
         }

         int[] m1 = new int[133];
         int[] m2 = new int[133];

        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i), y = t.charAt(i);
            
            if(m1[x] == 0){
                m1[x] = y;
            }
            else if(m1[x] != y){
                return false;
            }
            
            if(m2[y] == 0){
                m2[y] = x;
            }
            else if(m2[y] != x){
                return false;
            }
        }
        
        return true;
    }
}