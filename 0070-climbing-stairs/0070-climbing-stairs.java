class Solution {
    /*
        n = 1, // 1
        n = 2, // 2
        n = 3, // 3
        n = 4, // 5
        n = 5, // 8
        n = 6, // 
        
        1 1 1 1 1 1
        2 1 1 1 1
        1 2 1 1 1
        1 1 2 1 1
        1 1 1 2 1
        1 1 1 1 2
        
        2 2 1 1
        
    */
    public int climbStairs(int n) {
        int prev = 0, curr = 1;
        
        for(int i = 0; i < n; i++){
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        
        return curr;
    }
}