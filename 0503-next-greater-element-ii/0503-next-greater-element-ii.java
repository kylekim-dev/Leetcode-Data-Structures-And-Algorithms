class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /*
            Algorithms & DS: Stack
            Time: O(N), Extra Space: O(N)
         */

        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer, -1);

        for(int i = 0; i < n * 2; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                answer[stack.pop()] = nums[i % n];
            }

            stack.push(i % n);
        }
        
        return answer;
    }
}