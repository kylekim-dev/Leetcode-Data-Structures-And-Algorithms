class Solution {
    public boolean isValid(String s) {
        /*
            Algorithms && DS: Stack
            Time: O(N), Space: O(N)
            
        */
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.peek() == '(' && c == ')') stack.pop();
            else if(stack.peek() == '[' && c == ']') stack.pop();
            else if(stack.peek() == '{' && c == '}') stack.pop();
            else if(stack.isEmpty() && (c == ')' || c == ']' || c == '}')) return false;
            else return false;
        }
        
        return stack.isEmpty();
    }
}