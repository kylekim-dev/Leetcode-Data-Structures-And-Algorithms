class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            Algorithms & DS: #Sliding Window, #HashMap
            Time: O(N), Space: O(N)
         */

        int l = 0, r = 0;
        int bal = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (r < s2.length()){
            Character rChar = s2.charAt(r);

            if(map.containsKey(rChar)){
                map.put(rChar, map.get(rChar) - 1);
                bal--;
            }

            while (l < r && (r - l >= s1.length() || map.getOrDefault(rChar, 0) < 0)){
                Character lChar = s2.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.get(lChar) + 1);
                    bal++;
                }
                l++;
            }

            if(bal == 0){
                return true;
            }

            r++;
        }
        
        return false;
    }
}