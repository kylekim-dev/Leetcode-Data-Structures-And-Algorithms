class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] output = new int[heights.length];
        Stack<Integer> stack = new Stack<>(); // Mono Stack Decreasing

        for(int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                output[stack.pop()] += 1;
            }

            if(!stack.isEmpty()) output[stack.peek()] += 1;
            stack.push(i);
        }
        
        return output;
    }
}