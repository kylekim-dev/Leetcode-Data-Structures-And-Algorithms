class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String t:tokens) {
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res = 0;

                if(t.equals("+")){
                    res = a + b;
                }
                else if(t.equals("-")){
                    res = a - b;
                }
                else if(t.equals("*")){
                    res = a * b;
                }
                else if(t.equals("/")){
                    res = a / b;
                }

                stack.push(Integer.toString(res));
            }
            else {
                stack.push(t);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}