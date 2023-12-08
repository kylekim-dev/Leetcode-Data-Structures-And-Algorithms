class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Algorithm & DS: Two Pointer
        // Time: O(n), Extra Space: O(1)
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if(sum < target){
                l++;
            }
            else if(sum > target){
                r--;
            }
            else {
                return new int[]{l+1, r+1};
            }
        }
        
        return new int[2];
        
    }
}