class Solution {
    /*
        [3,1,2,1,4,1]
        
        [1 2 3 4] NLogN
        
        binary search
        [4,2,4,4,-1,4] NLogN
        
        [4,2,4,4,-1,4]
        
        
    */
    
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
    }
}