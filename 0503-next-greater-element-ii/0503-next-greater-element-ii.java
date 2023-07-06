class Solution {
    // Algorithm: Monotonic Stack (Forward)
    // Time: O(N), Space: O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                output[stack.pop()] = nums[i];
            }

            output[i] = -1;
            stack.push(i);
        }
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                output[stack.pop()] = nums[i];
            }

            stack.push(i);
        }
        
        return output;
    }
}