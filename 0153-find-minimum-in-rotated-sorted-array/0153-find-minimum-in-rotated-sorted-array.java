class Solution {
    public int findMin(int[] nums) {
        /*
            Algorithms & DS: Binary Search
            Time: O(LogN), Extra Space: O(1)
         */
        int l = 0, r = nums.length - 1;
        int m = (r + l) / 2;

        while (l < r - 1){
            if(nums[l] > nums[m] || nums[l] < nums[r]) r = m;
            else l = m;
            
            m = (r + l) / 2;
        }
        
        return Math.min(nums[l], nums[r]);
    }
}