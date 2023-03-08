class Solution {
    /*
        Input: nums =
        [2, 3, 1, 1, 4]
         4  4  4  4  4

        [3, 2, 1, 0, 4]
         3   3   3   3   4

        [3, 2, 2, 0, 4]
         4   4   4  3   4
        아이디어
            1. nums.length - 2부터 배열 탐색을 시작한다.
            2. j = 1부터 j < nums[i] 까지 탐색하면서 nums[nums[i] + j] 중에 가장 큰 숫자를 localMax에 저장한다.
            3. 가장 큰 숫자로 nums[i] = localMax로 업데이트 해준다.
            4. i가 0보다 작을때까지 2,3을 반복한다.
        자료구조
            O(N)
        시간복잡도

     */

    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        nums[n] = n;

        for(int i = n; i >= 0; i--){
            int maxJump = nums[i];
            nums[i] = i;

            for(int j = 1; j <= maxJump; j++){
                int jumpIndex = i + j;

                if(jumpIndex > n){
                    break;
                }

                if(nums[jumpIndex] == n){
                    nums[i] = n;
                    break;
                }
            }
        }

        return nums[0] == n;
    }
}