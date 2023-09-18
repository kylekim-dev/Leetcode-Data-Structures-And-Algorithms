class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;

        int[] alphaCount = new int[26];
        int oddCount = 0;

        for(Character c : s.toCharArray()){
            alphaCount[c - 'a'] += 1;
            if(alphaCount[c - 'a'] % 2 == 1) oddCount++;
            else oddCount--;
        }

        return oddCount <= k;
    }
}