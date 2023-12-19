class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int b = stack.pop();
                int a = stack.pop();

                if(t.equals("+")) stack.push(a + b);
                else if(t.equals("-")) stack.push(a - b);
                else if(t.equals("*")) stack.push(a * b);
                else if(t.equals("/")) stack.push(a / b);
            }
            else stack.push(Integer.parseInt(t));
        }
        
        return stack.pop();
    }
}