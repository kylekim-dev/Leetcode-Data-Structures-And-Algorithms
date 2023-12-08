class Solution {
    public int maxArea(int[] height) {
        // Algorithm & DS: Two Pointer
        // Time: O(n), Extra Space: O(1)

        int biggestArea = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);

            biggestArea = Math.max(biggestArea, area);

            if(height[l] <= height[r]) l++;
            else r--;
        }
        
        return biggestArea;
    }
}