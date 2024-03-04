class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * Algorithms & DS: #Sliding Window
         * Time: O(N), Extra Space: O(1)
         */
        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;

        while (r < nums.length || sum >= target) {
            if(sum >= target){
                ans = Math.min(ans, r - l);
                sum -= nums[l++];
            }
            else {
                sum += nums[r++];
            }
        }

        if(ans == Integer.MAX_VALUE)
            ans = 0;

        return ans;
    }
}