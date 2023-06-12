class Solution {
    /*
        I
        II
        III or IIV
        IV
        V
        
        
        MCMXCIV
        
        M:      1000
        MC:     1000 + 100
        MCM:    1000 - 100 + 1000
        MCMX:   1000 - 100 + 1000 + 10
        MCMXC:   1000 - 100 + 1000 - 10 + 100
        MCMXCI:   1000 - 100 + 1000 - 10 + 100 + 1
        MCMXCIV:   1000 - 100 + 1000 - 10 + 100 - 1 + 5
        
    */
    
    public int romanToInt(String s) {
        // Algorithm: Hash Table & Iterator
        // Time: O(N), Space: O(1)
        int num = 0, prev = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for(Character c : s.toCharArray()){
            if(map.get(c) > prev) num -= prev;
            else num += prev;
            
            prev = map.get(c);
        }
        
        return num + prev;
    }
}