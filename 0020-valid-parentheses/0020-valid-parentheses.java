class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.peek() == '(' && c == ')') stack.pop();
            else if(stack.peek() == '[' && c == ']') stack.pop();
            else if(stack.peek() == '{' && c == '}') stack.pop();
            else return false;
        }
        
        return stack.isEmpty();
    }
}