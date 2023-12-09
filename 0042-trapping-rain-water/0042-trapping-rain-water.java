class Solution {
    public int trap(int[] height) {
        // Algorithm & DS: Monotonic Stack
        // Time: O(n), Extra Space: O(n)

        Stack<Integer> monoStack = new Stack<>();
        int area = 0;

        for(int r = 0; r < height.length; r++){
            int prevMaxHeight = 0;

            while (!monoStack.isEmpty() && height[monoStack.peek()] <= height[r]){
                int l = monoStack.pop();
                int x = r - l - 1;
                int y = Math.min(height[l], height[r]);

                area += x * (y - prevMaxHeight);

                prevMaxHeight = height[l];
            }

            if(!monoStack.isEmpty()){
                int l = monoStack.peek();
                int x = r - l - 1;
                int y = Math.min(height[l], height[r]);
                area += x * (y - prevMaxHeight);
            }

            monoStack.push(r);
        }
        
        return area;
    }
}