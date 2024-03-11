class Solution {
    public int minAddToMakeValid(String s) {
        /*
         * Algorithms & DS: #Greedy
         * Time: O(N), Extra Space: O(1)
         */

        int bal = 0;
        int ans = 0;

        for(char c : s.toCharArray()){
            if(c == ')'){
                if(bal > 0) bal--;
                else ans++;
            }
            else {
                bal++;
            }
        }

        ans += bal;
        
        return ans;
    }
}