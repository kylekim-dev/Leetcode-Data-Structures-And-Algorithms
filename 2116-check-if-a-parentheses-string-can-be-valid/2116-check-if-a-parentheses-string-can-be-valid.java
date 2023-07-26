class Solution {
    /*
        Algorithm & DS: Greedy
        Time: O(N), Space: O(1)
    */
    public boolean canBeValid(String s, String locked) {
        int open = 0, openAndWild = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = locked.charAt(i) == '0' ? '*' : s.charAt(i);

            open += c == '(' ? 1 : -1;
            openAndWild += c != ')' ? 1 : -1;
            if (openAndWild < 0) break;
            open = Math.max(open, 0);
        }
        
        return open == 0 && openAndWild % 2 == 0;
    }
}