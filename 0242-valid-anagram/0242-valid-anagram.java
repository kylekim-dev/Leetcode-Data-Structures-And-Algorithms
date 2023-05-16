class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(Character c : t.toCharArray()){
            if(map.getOrDefault(c, 0) == 0){
                return false;
            }
            
            map.put(c, map.get(c) - 1);
        }
        
        return true;
    }
}