class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Algorithm & DS: Sliding Window
        // Time: O(n), Extra Space: O(1)
        int longest = 0;
        int l = 0, r = 0;
        int[] arr = new int[128];

        Arrays.fill(arr, -1);

        while (r < s.length()){
            int curr = s.charAt(r);

            if(arr[curr] >= 0){
                if(arr[curr] >= l){
                    l = arr[curr] + 1;
                }
            }

            longest = Math.max(longest, r - l + 1);
            arr[curr] = r;

            r++;
        }
        
        return longest;
    }
}