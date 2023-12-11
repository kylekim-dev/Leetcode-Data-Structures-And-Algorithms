class Solution {
    public int characterReplacement(String s, int k) {
        // Algorithm & DS: Sliding Window
        // Time: O(n), Extra Space: O(1)
        int longest = 0;
        int l = 0, r = 0;
        int[] arr = new int[26];
        int mostIdx = 0;

        while (r < s.length()){
            int currAlpha = s.charAt(r) - 'A';
            arr[currAlpha] += 1;
            // most index
            if(arr[mostIdx] < arr[currAlpha]){
                mostIdx = currAlpha;
            }
            
            while (r - l + 1 > k + arr[mostIdx]){
                int leftAlpha = s.charAt(l) - 'A';
                arr[leftAlpha] -= 1;
                l += 1;

                if(leftAlpha == mostIdx){
                    break;
                }
            }

            longest = Math.max(longest, r - l + 1);
            r++;
        }
        
        return longest;
    }
}