class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int INF = Integer.MAX_VALUE;
        int[] accArray = new int[nums.length + 1];
        int accSum = 0;
        int result = INF;
        int left, right;

        for(int i = 1; i < accArray.length; i++){
            accSum += nums[i - 1];
            accArray[i] += accSum;
        }

        accSum = 0;
        left = 0;
        right = 1;

        while (right < accArray.length) {
            accSum = accArray[right] - accArray[left];

            if(accSum < target){
                right++;
            }
            else if(accSum >= target){
                result = Math.min(result, right - left);
                left++;
            }
        }

        return result == INF ? 0 : result;
    }
}