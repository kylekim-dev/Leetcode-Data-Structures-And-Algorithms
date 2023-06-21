class Solution {
    /*
        [-3,-2,1,5,6,4], k = 2
        
        max: 6
        min: -3
        count: int[max - min + 1] = int[10]
        
        0 1 2 3 4 5 6 7 8 9
        1 1     1     1 1 1  
        
        
        
        
    */
    public int findKthLargest(int[] nums, int k) {
        // Algorithm: Counting Sort
        // Time: O(N + M), Space: O(M)
        // N >= M (M is size of freq array)
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);  
        } 
        
        int[] freq = new int[max - min + 1];
        
        for (int num : nums) freq[num - min]++;
        
        for(int num = freq.length - 1; num >= 0; num--){
            k -= freq[num];
            if(k <= 0) return num + min;
        }
        
        return -1;
    }
}