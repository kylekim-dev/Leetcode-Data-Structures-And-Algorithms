class Solution {
    /*
        Algorithm & DS: Stack        
        Time: O(N), Space: O(N)
    */
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int openCount = 0;

        for(Character c : s.toCharArray()){
            if(c == '('){
                openCount++;
            }
            else if(c == ')'){
                if(openCount == 0) continue;
                else openCount--;
            }

            stack.push(c);
        }

        while (!stack.isEmpty()){
            Character c = stack.pop();
            if(openCount > 0 && c == '('){
                openCount--;
                continue;
            }
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}