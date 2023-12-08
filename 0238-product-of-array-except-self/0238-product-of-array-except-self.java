class Solution {
    /*
        // Algorithm & DS: prefixSum
        // Time: O(n), Extra Space: O(1)
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefixSum = 1;
        int zeroIdx = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if (zeroIdx >= 0){
                    return res;
                }
                else {
                    zeroIdx = i;
                }
            }
            else {
                prefixSum *= nums[i];
            }
        }

        if(zeroIdx >= 0){
            res[zeroIdx] = prefixSum;
        }
        else {
            for(int i = 0; i < nums.length; i++){
                res[i] = prefixSum / nums[i];
            }
        }

        return res;
    }
}