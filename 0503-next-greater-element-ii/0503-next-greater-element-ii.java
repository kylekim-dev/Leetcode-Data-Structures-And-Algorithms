class Solution {
    /*
        [3,1,2,1,4,1]
        
    */
    /*
    // Brute-force
    // O(N^2) O(N)
    public int[] nextGreaterElements(int[] nums) {
        int[] output = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            int nextGreater = -1;
            
            for(int j = 0; j < nums.length; j++){
                if(nums[i] < nums[(i + j) % nums.length]){
                    nextGreater = nums[(i + j) % nums.length];
                    break;
                }
            }
            
            output[i] = nextGreater;
        }
        
        return output;
    }*/
    /*
        [3,1,2,1,4,1]
        [4,2,4,4,-1,3]
    */
    // Algorithm: Monotonic Stack
    // Time: O(N), Space: O(N)
    public int[] nextGreaterElements(int[] nums) {
        int[] output = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        
        for(int c = 0; c < 2; c++){
            for(int i = nums.length - 1; i >=0; i--){
                while(!s.isEmpty() && s.peek() <= nums[i]) s.pop();

                output[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
        }
        
        return output;
    }
}