class Solution {
    /*
        x = r - l
        y = min(h[l], h[r])
        output = x * y;
        
    */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        int x, y;
        
        while (l < r){
            x = r - l;
            y = Math.min(height[l], height[r]);

            maxArea = Math.max(maxArea, x * y);
            
            if(y == height[r]) r -= 1;
            else l += 1;
        }
        
        return maxArea;
    }
}