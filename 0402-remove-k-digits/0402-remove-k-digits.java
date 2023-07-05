class Solution {
    /*
    
        1432219, k = 3
        
        1219
        
        
        
    
        4102565, k = 2
        
        stack.peek() > curr >>> stack.pop()
        
        52001204, k = 3, len = 8 // stack 5
        
        같거나 크면 버린다.
        pop할떄마다 k를 감소 시킨다.
        stack empty인데 input value > 0 일때만 푸쉬
        
        0
    */
    public String removeKdigits(String num, int k) {
        // Alogrithm: Monotonic Stack
        // Time: O(N), Space: O(N)
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(Character c : num.toCharArray()){
            while(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            
            if(stack.isEmpty() && c == '0') continue;
            stack.push(c);
        }
        
        while(!stack.isEmpty()){
            Character c = stack.pop();
            if(k > 0) k--; 
            else sb.insert(0, c);
        }
        
        if(sb.isEmpty()) sb.append('0');
        
        return sb.toString();
    }
}