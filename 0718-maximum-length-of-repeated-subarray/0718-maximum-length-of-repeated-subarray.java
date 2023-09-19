class Solution {
    /*
        Algorithms & Data Structure: DP
        Time: O(N^2), Space: O(N)
    */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;

        for(int i1 = 0; i1 < dp.length; i1++){
            for(int i2 = 0; i2 < dp[i1].length; i2++){
                if(nums1[i1] == nums2[i2]){
                    if(i1 - 1 >= 0 && i2 - 1 >= 0)
                        dp[i1][i2] = dp[i1 - 1][i2 - 1];
                    dp[i1][i2]++;
                }

                if(max < dp[i1][i2]) max = dp[i1][i2];
            }
        }
        
        return max;
    }
}