class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        HashSet<Character> check = new HashSet<>();
        int l, r;

        l = r = 0;

        while (r < s.length()){
            char c = s.charAt(r);

            while (check.contains(c)){
                char leftVal = s.charAt(l);
                check.remove(leftVal);
                l += 1;
            }

            check.add(c);
            longest = Math.max(longest, r - l + 1);
            r += 1;
        }

        return longest;
        
    }
}