class Solution {
    public boolean isValid(String s) {
        // Algorithm: Stack, Iterator
        // Time: O(N), Space: O(N)
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        
        return stack.isEmpty();
    }
}