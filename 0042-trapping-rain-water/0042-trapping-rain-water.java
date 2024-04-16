class Solution {
    public int trap(int[] height) {
        /*
            Algorithms & DS: #Two Pointer
            Time: O(N), Space: O(1)
         */
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int ans = 0;
        int r = height.length - 1;

        leftMax[0] = height[0];
        rightMax[r] = height[r];
        
        for(int l = 1; l < height.length; l++){
            r -= 1;
            leftMax[l] = Math.max(leftMax[l - 1], height[l]);
            rightMax[r] = Math.max(rightMax[r + 1], height[r]);
        }
        
        
        for(int i = 0; i < height.length; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return ans;
    }
}