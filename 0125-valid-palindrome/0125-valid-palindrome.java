class Solution {
    public boolean isPalindrome(String s) {
        // Algorithm & DS: Two Pointer
        // Time: O(n), Extra Space: O(1)

        int l = 0, r = s.length() - 1;

        while (l < r){
            if(!Character.isAlphabetic(s.charAt(l)) && !Character.isDigit(s.charAt(l))){
                l++;
                continue;
            }

            if(!Character.isAlphabetic(s.charAt(r)) && !Character.isDigit(s.charAt(r))){
                r--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;

            l++;
            r--;
        }
        
        return true;
    }
}