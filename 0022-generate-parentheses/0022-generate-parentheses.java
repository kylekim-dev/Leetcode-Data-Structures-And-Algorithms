class Solution {
    public List<String> generateParenthesis(int n) {
        /*
         * Algorithms & Data Structure: Backtrcking 
         * Time Complexity:  O(2^N)
         * Space Complexity: O(N)
         */
        
        List<String> ans = new ArrayList<>();

        rec(n, n, new StringBuilder(), ans);

        return ans;
    }

    public void rec(int opener, int closer, StringBuilder sb, List<String> ans){
        if(opener == 0 && closer == 0){
            ans.add(sb.toString());
            return;
        }

        if(opener > 0){
            sb.append("(");
            rec(opener - 1, closer, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closer > 0 && opener < closer){
            sb.append(")");
            rec(opener, closer - 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}