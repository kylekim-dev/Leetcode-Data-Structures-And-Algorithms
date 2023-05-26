class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Algorithm: Two Pointer, HashSet
        // Time: O(N), Space: O(N)
        int longest = 0;
        int l = 0, r = 0;
        boolean[] set = new boolean[256];
        
        while(r < s.length()){
            if(set[s.charAt(r)]){
                set[s.charAt(l)] = false;
                l += 1;
            }
            else {
                set[s.charAt(r)] = true;
                longest = Math.max(longest, r - l  + 1);
                r += 1;
            }
        }
        
        return longest;
    }
    
    /*
    public int lengthOfLongestSubstring(String s) {
        // Algorithm: Two Pointer, HashSet
        // Time: O(N), Space: O(N)
        int longest = 0;
        int l = 0, r = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while(r < s.length()){
            if(set.contains(s.charAt(r) - 'a')){
                set.remove(s.charAt(l) - 'a');
                l += 1;
            }
            else {
                set.add(s.charAt(r) - 'a');
                longest = Math.max(longest, r - l  + 1);
                r += 1;
            }
        }
        
        return longest;
    }*/
}