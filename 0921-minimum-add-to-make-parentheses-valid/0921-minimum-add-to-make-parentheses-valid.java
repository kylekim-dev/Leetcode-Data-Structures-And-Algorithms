class Solution {
    /*
        Algorithm & DS: Iterator
        Time: O(N), Space: O(1)
    */
    public int minAddToMakeValid(String s) {
        int output = 0, openerCount = 0;
        
        for(Character c : s.toCharArray()){
            if (c == '(') openerCount++;
            else {
                if (openerCount == 0) output++;
                else openerCount--;
            }
        }
        
        return output + openerCount;
    }
}