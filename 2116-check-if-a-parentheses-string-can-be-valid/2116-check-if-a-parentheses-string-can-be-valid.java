class Solution {
    /*
         *****
         01234567890123456789012345678901
        "((()(()()))()((()()))))()((()(()"
        "10111100100101001110100010001001"
        
        o: 1 1 2 1 
        w: 1 1 1 1
        
        
    */
    public boolean canBeValid(String s, String locked) {
        int lo = 0, hi = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = locked.charAt(i) == '0' ? '*' : s.charAt(i);

            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        
        return lo == 0 && hi % 2 == 0;
    }
}