class Solution {
    /*
        n = nums.size();
        a = leftSum / n
        b = (rightSum - leftSum) / n
        minVal, minIdx

        Algorithm & DS: Accumulated Sum
        Time: O(N), Space: O(1)
        Note: 배열의 모든 숫자를 합한 숫자 Total > Integer Max Value 이므로 Long Type 필요. 

        4 1 = 3
        3 0 = 3
    */
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long rightSum = 0, leftSum = 0, minVal = Long.MAX_VALUE; 
        int minIdx = 0;
        
        for(int i = 0; i < n; i++) rightSum += nums[i]; // 배열 내 모든 숫자를 더함.

        for(int i = 0; i < n; i++){
            leftSum += nums[i];
            rightSum -= nums[i];

            long a = leftSum / (i + 1); // 왼쪽 윈도우의 평균
            long b = n - i - 1 == 0 ? 0 : rightSum / (n - i - 1); // 오른쪽 윈도우의 평균, 분모가 0인 경우 예외 처리 필요.

            // 최소 평균값을 찾으면 갱신.
            if(minVal > Math.abs(a - b)){
                minVal = Math.abs(a - b);
                minIdx = i;
            }
        }

        return minIdx;
    }
}