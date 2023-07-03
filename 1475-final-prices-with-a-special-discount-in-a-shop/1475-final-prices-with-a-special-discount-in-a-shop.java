class Solution {
    /*
        [8,4,6,2,3]
        
        4,2,4,2,3
    
        [8,4,6,4,5,2]
        
        4 6 4
        
        ans: 4
        
        ans: 4 0 2 2 3 2
            
    */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            ans[i] = prices[i];
            while(!stack.isEmpty() && stack.peek()[0] >= prices[i]){
                Integer[] temp = stack.pop();
                ans[temp[1]] = temp[0] - prices[i];
            }
            
            stack.push(new Integer[]{prices[i], i});
        }
        
        return ans;
    }
}