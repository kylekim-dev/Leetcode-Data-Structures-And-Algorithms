class Solution {
    /*
        // Algorithm: Monotonic-Stack
        // Time: O(N), O(N) 
        // N = 10^5 = 10^10 = ~10s, Timeout!!
        // O(NLogN)이하의 시간복잡도 알고리즘을 찾아야됨! 
        
        
        전략
        1. 배열 heights의 끝부분부터 탐색을 시작한다.
        2. output[i] = stack.size()
        3. 현재의 높이 h[i] > stack.peek() stack의 값을 pop해주고 popCount 1증가시켜준다. (stack이 비어있으면 비교를 멈춘다)
        4. 3번을 완료하면 자신보다 작은 기둥들을 모두 제거한 상태, 만약 Stack이 비어있지 않으면 자신보다 큰 사람이 있으므로 1을 증가시켜준다.
        5. Stack에 h[i]를 넣어준뒤, i >= 0면 2,3번을 반복한다.
        
        
        [10,6,1,5,11,9]
        [2, 3 1 1 1 0]
        [10 11]
    */
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int popCount;
        
        for(int i = heights.length - 1; i >= 0; i--){
            int height = heights[i];
            popCount = 0;
            
            while(!stack.isEmpty() && height > stack.peek()) {
                stack.pop();
                popCount++;
            }
            
            if(!stack.isEmpty()) popCount++;

            heights[i] = popCount;
            
            stack.push(height);
        }
        
        return heights;
    }
    /*
    // Algorithm: Brute-Force
    // Time: O(N^2), O(1) 
    // N = 10^5 = 10^10 = ~10s, Timeout!!
    // O(NLogN)이하의 시간복잡도 알고리즘을 찾아야됨! 
    public int[] canSeePersonsCount(int[] heights) {
        for(int i = 0; i < heights.length; i++){
            int count = 0, localMax = 0;
            
            for(int j = i + 1; j < heights.length; j++){
                if(localMax < heights[j]){
                    localMax = heights[j];
                    count++;
                    
                    if(heights[i] < localMax) break;
                }
            }
            
            heights[i] = count;
        }
        
        return heights;
    }*/
}