class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            Algorithms & HashMap
            Time: O(N), Extra Space: O(N)
         */

        boolean[] map = new boolean[128];
        int answer = 0;
        int l = 0, r = 0;

        while (r < s.length()){
            if(map[s.charAt(r)]){

                while (map[s.charAt(r)])
                    map[s.charAt(l++)] = false;
            }

            map[s.charAt(r)] = true;
            answer = Math.max(answer, r - l + 1);

            r++;
        }
        
        return answer;
    }
}