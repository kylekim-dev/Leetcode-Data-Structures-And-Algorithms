class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxF = 0;
        int l, r;
        int output = 0;

        l = r = 0;

        while (r < s.length()){
            int key = s.charAt(r) - 65;
            freq[key] += 1;
            maxF = Math.max(maxF, freq[key]);

            while ((r - l + 1) - maxF > k){
                key = s.charAt(l) - 65;
                freq[key] -= 1;
                l += 1;
            }

            output = Math.max(output, (r - l + 1));
            r += 1;
        }

        return output;
    }
}