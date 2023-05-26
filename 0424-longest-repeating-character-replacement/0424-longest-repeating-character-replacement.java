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
        int l = 0, r = 0;
        int lKey, rKey, len;
        int most = 0, maxFreq = 0;
        
        l = r = 0;

        while (r < s.length()){
            lKey = s.charAt(r) - 'A';
            freq[lKey] += 1;
            most = Math.max(most, freq[lKey]);
            len = r - l + 1;

            if(len - most > k){
                rKey = s.charAt(l) - 'A';
                freq[rKey] -= 1;
                freq[lKey] -= 1;
                l += 1;
            }
            else {
                maxFreq = Math.max(maxFreq, len);
                r += 1;
            }
        }

        return maxFreq;
    }
}