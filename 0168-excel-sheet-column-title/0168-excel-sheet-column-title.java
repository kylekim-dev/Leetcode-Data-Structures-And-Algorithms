class Solution {
    public String convertToTitle(int columnNumber) {
        /*
            Algorithms & DS: Iterator
            Time: O(Log_26_N), Extra Space: O(1)
         */

        int mod = 26;
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber -= 1;
            sb.insert(0, (char)((columnNumber % mod) + 'A'));
            columnNumber /= mod;
        }
        
        return sb.toString();
    }
}