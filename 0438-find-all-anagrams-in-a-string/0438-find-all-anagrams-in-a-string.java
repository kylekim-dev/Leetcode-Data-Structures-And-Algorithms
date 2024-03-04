class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        /*
         * Algorithms & DS: #Sliding Window
         * Time: O(N), Extra Space: O(M)
         * M: P.length
         */

        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int bal = 0;

        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            bal++;
        }

        int l = 0, r = 0;

        while (r < s.length()) {
            Character rightAlpha = s.charAt(r);
            if(map.containsKey(rightAlpha)){
                map.put(rightAlpha, map.get(rightAlpha) - 1);
                if(map.get(rightAlpha) >= 0){
                    bal--;
                }
            }
                
            if(r >= p.length()){
                Character leftAlpha = s.charAt(l);

                if(map.containsKey(leftAlpha)){
                    map.put(leftAlpha, map.get(leftAlpha) + 1);
                    if(map.get(leftAlpha) > 0){
                        bal++;
                    }
                }
                l++;
            }

            if(bal == 0){
                ans.add(l);
            }

            r++;
        }
        
        return ans;
    }
}