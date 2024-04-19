class Solution {
    public int evalRPN(String[] tokens) {
        /*
            Algorithms & DS: Stack
            Time: O(N), Extra Space: O(N)
        */
        Stack<Integer> stack = new Stack<>();
        String[] operands = {"+", "-", "*", "/"};
        HashSet<String> operandSet = new HashSet<>(Arrays.asList(operands));

        for (String t : tokens) {
            if(operandSet.contains(t)){
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