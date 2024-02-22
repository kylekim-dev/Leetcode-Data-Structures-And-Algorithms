class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
            Algorithms & DS: #Two Pointer
            Time: O(n), Extra Space: O(1)
         */

        int l = 0, r = numbers.length - 1;

        while (l < r){
            if(target > numbers[r] + numbers[l]) l++;
            else if(target < numbers[r] + numbers[l]) r--;
            else break;
        }
        
        return new int[] {l+1, r+1};
    }
}