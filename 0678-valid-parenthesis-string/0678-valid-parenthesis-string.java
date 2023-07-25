class Solution {
    /*
        *: wild card
        Algorithm & DS: Greedy
        Time: O(N), Space: O(1)
    */
    public boolean checkValidString(String s) {
        int open = 0, starAndOpen = 0;
        
        for(Character c : s.toCharArray()){
            if(c == '(') open++;
            else open--;
            
            if(c == '(' || c == '*') starAndOpen++;
            else starAndOpen--;
            
            if(starAndOpen < 0) break; // close start case like )(**
        
            open = Math.max(open, 0);
        }
        
        return open == 0;
    }
}