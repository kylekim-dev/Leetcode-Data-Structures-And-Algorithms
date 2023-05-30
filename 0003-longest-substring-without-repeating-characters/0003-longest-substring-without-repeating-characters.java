class Solution {
    /*
        r       l       longest     string
        0       0       1           a
        0       1       2           ab
        0       2       3           abc
        1       3       3           abca    ->  bca
        2       4       3           bcab    ->  cab
        3       5       3           cabc    ->  abc
        5       6       3           abcb    ->  bcb -> cb
        7       7       3           cbb     ->  bb  ->  b
    */
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
}