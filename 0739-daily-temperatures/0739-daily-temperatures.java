class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        /*
            Algorithms & DS: #Sliding Window, #Monotonic-Stack
            Time: O(N), Space: O(N)
         */

        int[] ans = new int[temperatures.length];
        Stack<Integer> monoStack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while (!monoStack.isEmpty() && temperatures[monoStack.peek()] < temperatures[i]){
                int warmerIdx = monoStack.pop();
                ans[warmerIdx] = i - warmerIdx;
            }

            monoStack.push(i);
        }
        
        return ans;
    }
}