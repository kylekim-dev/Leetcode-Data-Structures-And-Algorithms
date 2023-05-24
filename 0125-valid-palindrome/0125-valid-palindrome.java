class Solution {
    public boolean isAlphabetic(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()- 1;
        while(l < r){
            if(!isAlphabetic(s.charAt(l))) l += 1;            
            else if(!isAlphabetic(s.charAt(r))) r -= 1;    
            else if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            else {
                l += 1;
                r -= 1;
            }
        }
        
        return true;
    }
}