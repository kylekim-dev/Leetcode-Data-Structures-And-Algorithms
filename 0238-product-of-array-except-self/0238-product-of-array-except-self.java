class Solution {
    /*
        [-1,1,0,-3,3]
        
        [],[1,2,3,4], i = 0
        [0]x[2,3,4], i = 1
        [0,1]x[3,4], i = 2
        [0,1,2]x[4], i = 3
        [0,1,2,3][], i = 4
        
        min len = 2
        
        [-1,1,0,-3,3], total 9
        0 0 9 
        
    */
    public int[] productExceptSelf(int[] nums) {
        // Algorithm && DS: Prefix
        // Time: O(N), Space: O(1)
        
        int total = 1, zeroCount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroCount++;
            else total *= nums[i];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(zeroCount >= 1){
                if(nums[i] == 0 && zeroCount == 1) nums[i] = total; 
                else nums[i] = 0;
            }
            else {
                nums[i] = total / nums[i];
            }
        }
        
        return nums;
    }
}