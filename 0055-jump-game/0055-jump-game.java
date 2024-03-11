class Solution {
    public boolean canJump(int[] nums) {
        /*
            Algorithms & DS: #Greedy
            Time: O(N), Extra Space: O(1)
         */

        int n = nums.length - 1;
        int portal = n;
        
        if(n == 0){
            return true;
        }

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= portal){
                nums[i] = n;
                portal = i;
            }
        }
        
        return nums[0] == nums.length - 1;
    }
}