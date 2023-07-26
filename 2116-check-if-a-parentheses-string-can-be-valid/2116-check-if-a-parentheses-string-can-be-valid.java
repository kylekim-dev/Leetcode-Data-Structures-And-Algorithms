class Solution {
    /*
        Algorithm & DS: Greedy
        Time: O(N), Space: O(1)
    */
    public boolean canBeValid(String s, String locked) {
        int open = 0, openAndWild = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(locked.charAt(i) == '1' && s.charAt(i) == '(') open++;
            else open--;
            
            if(locked.charAt(i) == '0' || s.charAt(i) == '(') openAndWild++;
            else openAndWild--;
            
            if (openAndWild < 0) break;
            open = Math.max(open, 0);
        }
        
        return open == 0 && openAndWild % 2 == 0;
    }
}