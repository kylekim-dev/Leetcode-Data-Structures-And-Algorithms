class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
        }

        int l = 0, r = 0;

        while (r < s2.length()){
            char rightChar = s2.charAt(r);

            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                count--;
            }

            if(!map.containsKey(rightChar)) {
                while (l <= r){
                    char leftChar = s2.charAt(l);
                    if(map.containsKey(leftChar)){
                        map.put(leftChar, map.get(leftChar) + 1);
                        count++;
                    }
                    l++;
                }
            }
            else if(map.get(rightChar) < 0){
                while (l <= r && map.get(rightChar) < 0){
                    char leftChar = s2.charAt(l);
                    if(map.containsKey(leftChar)){
                        map.put(leftChar, map.get(leftChar) + 1);
                        count++;
                    }
                    l++;
                }
            }

            if(count == 0){
                return true;
            }
            r++;
        }

        
        return false;
    }
}