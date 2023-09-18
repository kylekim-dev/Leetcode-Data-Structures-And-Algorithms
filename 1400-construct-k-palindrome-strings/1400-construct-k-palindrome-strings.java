class Solution {
    /*
        Algorithms & Data Structure: HashMap
        Time: O(N), Space: O(1)
    */
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;

        int[] alphaCount = new int[26];

        for(Character c : s.toCharArray()){
            alphaCount[c - 'a'] += 1;
        }
        
        int oddCount = 0;

        for(int count : alphaCount){
            if(count % 2 == 1) oddCount++;
        }
        
        return oddCount <= k;
    }
}