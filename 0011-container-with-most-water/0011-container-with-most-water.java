class Solution {
    public int maxArea(int[] height) {
        /*
         * Algorithms & DS: #Two Pointer
         * Time: O(N), Extra Space: O(1)
         */
        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);

            if(height[l] < height[r]) l++;
            else r--;

            maxArea = Math.max(maxArea, area);
        }


        return maxArea;
    }
}