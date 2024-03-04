class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        /*
         * Algorithms & DS: #Sliding Window
         * Time: O(N), Extra Space: O(M)
         * M: P.length
         */

        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;

        while (r < s.length()) {
            Character rightAlpha = s.charAt(r);
            if(map.containsKey(rightAlpha)){
                map.put(rightAlpha, map.get(rightAlpha) - 1);
            }
                
            if(r >= p.length()){
                Character leftAlpha = s.charAt(l);

                if(map.containsKey(leftAlpha)){
                    map.put(leftAlpha, map.get(leftAlpha) + 1);
                }
                l++;
            }

            boolean isAnagram = true;

            for(Integer val : map.values()){
                if(val > 0){
                    isAnagram = false;
                    break;
                }
            }

            if(isAnagram){
                ans.add(l);
            }

            r++;
        }
        
        return ans;
    }
}