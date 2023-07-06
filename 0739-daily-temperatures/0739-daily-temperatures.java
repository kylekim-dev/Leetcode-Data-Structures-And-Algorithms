class Solution {
    /*
        디크리징 스택
         0  1  2  3  4   5  6 7
        [73,74,75,71,69,72,76,73]
        [4 2 1 1 0 0]
        74 75 76
    
        stack이 존재하지 않으면 본인이 제일 큰 것이므로 0
        stack이 존재하면 peek의 인덱스 j와 현재 인덱스 i를 뺀 j - i를 넣어준다.
    */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()) ans[i] = stack.peek() - i;
            stack.push(i);
        }
        
        return ans;
    }
}