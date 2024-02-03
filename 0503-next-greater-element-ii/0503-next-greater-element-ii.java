class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /*
            Algorithms & DS: Monotonic stack
            Time: O(N), Extra Space: O(N)
        */
        Stack<Integer> monoStack = new Stack<>(); 
        int[] output = new int[nums.length];

        Arrays.fill(output, -1);
        for(int c = 0; c < 2; c++){
            for(int i = 0; i < nums.length; i++){
                while(!monoStack.isEmpty() && nums[monoStack.peek()] < nums[i]){
                    output[monoStack.pop()] = nums[i];
                }

                monoStack.push(i);
            }
        }

        return output;
    }
}