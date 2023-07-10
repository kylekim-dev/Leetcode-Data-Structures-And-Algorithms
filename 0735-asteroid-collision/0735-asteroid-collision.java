class Solution {
    /*
        Test Case:
        2 -5 5 10 -5
        posi 5 10
        nega -5
        ans: -5 5 10
        
        Algorithm & DS: Stack
        Time: O(N), Space: O(N)
        
        전략:
        1. 배열의 끝부터 탐색을 시작한다.
        2. 만약 현재 운석이 음수이면 stack에 모아준다.
        3. 만약 양수 운석이면 음수 stack에 운석과 충돌시키고 현재 운석보다 작은 운석들을 스택에서 꺼내준다.
        4. 만약 음수 운석 스택에 아무것도 없다면 양수 운석 스택에 현재 운석을 모아준다. 만약 크기가 같은 운석이면 음수 스택에서 해당 운석을 pop 해준다.
        5. 2 - 5를 반복한다.
        6. 음수 운석에 
        
        
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> posi = new Stack<>();
        Stack<Integer> nega = new Stack<>(); // Increasing -10 -5 -1
        
        for(int i = asteroids.length - 1; i >= 0; i--){
            if(asteroids[i] < 0) nega.push(asteroids[i]);
            else {
                while(!nega.isEmpty() && Math.abs(nega.peek()) < asteroids[i]){
                    nega.pop();
                }
                
                if(nega.isEmpty()) posi.push(asteroids[i]);
                else if(Math.abs(nega.peek()) == asteroids[i]) nega.pop();
            }
        }
        
        int[] output = new int[posi.size() + nega.size()];
        int i = 0;
        
        while(!nega.isEmpty()){
            output[i] = nega.pop();
            i++;
        }
        
        while(!posi.isEmpty()){
            output[i] = posi.pop();
            i++;
        }
        
        return output;
    }
}