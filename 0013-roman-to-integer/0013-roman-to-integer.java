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
        int[] map = new int[26];
        Character A = 'A';
        map['I' - A] = 1;
        map['V' - A] = 5;
        map['X' - A] = 10;
        map['L' - A] = 50;
        map['C' - A] = 100;
        map['D' - A] = 500;
        map['M' - A] = 1000;
        
        for(Character curr : s.toCharArray()){
            if(map[curr - A] > prev) num -= prev;
            else num += prev;
            
            prev = map[curr - A];
        }
        
        return num + prev;
    }
}