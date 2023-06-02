class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character a = s.charAt(i);
            if (stack.isEmpty() || a == '(' || a == '[' || a == '{'){
                stack.push(a);  
            }
            else {
                Character b = stack.pop();
                if((a == ')' && b != '(') || (a == ']' && b != '[') || (a == '}' && b != '{')) return false;
            }
        }
        
        return stack.isEmpty();
    }
}