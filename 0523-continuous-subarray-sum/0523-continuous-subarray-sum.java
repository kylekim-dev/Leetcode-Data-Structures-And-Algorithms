class Solution {
    /*
        Algorithm & DS: PrefixSum
        Time: O(N), Space: O(N)
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // remainder of prefix, index
        int prefixSum = 0;

        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int remainder = prefixSum % k;
            if(map.containsKey(remainder) && map.get(remainder) != i - 1) return true;
            if(!map.containsKey(remainder)) map.put(remainder, i);
        }

        return false;
    }
}