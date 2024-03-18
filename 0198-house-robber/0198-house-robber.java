class Solution {
    public int rob(int[] nums) {
        /*
            Algorithms & DS: #DP, #Memoezation
            Time: O(N), Extra Space: O(1)
         */

        int n = nums.length;
        int p1 = 0, p2 = 0;

        p1 = nums[0];

        if(n > 1){
            p2 = nums[0];
            p1 = Math.max(nums[1], p2);
        }

        for(int i = 2; i < n; i++){
            int temp = p1;
            p1 = Math.max(p2 + nums[i], p1);
            p2 = temp;
        }
        
        return p1;
    }
}