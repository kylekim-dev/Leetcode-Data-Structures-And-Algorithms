class Solution {
    /*
        Algorithm & DS: Stack
        Time: O(N), Space: O(N)
    */
    public int minAddToMakeValid(String s) {
        int output = 0;
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) output++;
                else stack.pop();
            }
        }
        
        output += stack.size();
        
        return output;
    }
}