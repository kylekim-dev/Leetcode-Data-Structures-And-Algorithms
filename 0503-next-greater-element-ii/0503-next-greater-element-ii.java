class Solution {
    // Algorithm: Monotonic Stack (Backward)
    // Time: O(N), Space: O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int c = 0; c < 2; c++){
            for(int i = n - 1; i >=0; i--){
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                    stack.pop();
                
                if(stack.isEmpty()) output[i] = -1;
                else output[i] = nums[stack.peek()];
                
                stack.push(i % n);
            }
        }
        
        return output;
    }
}