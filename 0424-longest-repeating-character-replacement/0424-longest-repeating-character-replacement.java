class Solution {
    /*
        AABABBA, K = 2
        
        l   r   lFreq   rFreq   diff    maxFrq
        0   0   1       1       0       1
        0   1   2       2       0       2
        0   2   2       1       1(A)    3
        0   3   3       1       1(A)    4
        0   4   3       2       2(A)    5
        0   5   3       3       3(A,B)  x
        1   5   2       3       2(A)    5
        1   6   3       3       3(A,B)  x
        2   6   2       3       2(B)    5
    
    */
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxF = 0;
        int l, r;
        int output = 0;

        l = r = 0;

        while (r < s.length()){
            int key = s.charAt(r) - 'A';
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