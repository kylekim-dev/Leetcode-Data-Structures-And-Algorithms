class Solution {
    public int singleNumber(int[] nums) {
        int output = 0;
        for(int val : nums) output ^= val;
        return output;
    }
}