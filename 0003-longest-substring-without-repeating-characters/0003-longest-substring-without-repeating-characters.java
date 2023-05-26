class Solution {
    public int lengthOfLongestSubstring(String s) {
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
    }
}