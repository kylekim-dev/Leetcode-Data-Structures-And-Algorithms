class Solution {
    /*  
         0  1   2 3   4  5  6   7  8
        [-2,1,-3, 4, -1, 2, 1, -5, 4]

        i
        0 -2        -2
        1  1        1
        2  -3 + 1   1
        3   4       4
        
    */
    public int maxSubArray(int[] nums) {
        int prevSum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            prevSum = nums[i] + prevSum;
            max = Math.max(prevSum, max);
            if(prevSum < 0) prevSum = 0;
        }
        
        return max;
    }
}