class Solution {
    /*
        (4 + 6 - 4) % 6
       (len + curr Index - times) % length
        0 1 2 3 4 5 6
       *4,5,6,7,0,1,2
       
       0 1 2 3 4 5 6
       4,5,6,7,0,1,2
       
       0, 3, 6 >> 4 7 2
       3, 4, 6 >> 7 0 2
       4, 5, 6 >> 0 1 2
       4, 4, 5 >> 0 0 2
       4, 4, 4 >> out
       
                        l     m     r
       l < m && m < r  [0,1,2,3,4,5,6]  >> r = m
       l < m && m > r  [4,5,6,7,0,1,2]  >> l = m
       l > m && m < r  [5,6,7,0,1,2,4]  >> l = m
      
      [2, 1]
      
      2 < 2  2 < 1
      
       0 1 2 3 4
      [5,1,2,3,4]
      
      0 2 4 >> 5 2 4
      0 1 2 >> 5 1 2
      0 0 1 >> 5 5 1
      
    
    */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int m = (r + l) / 2;
        
        while(l < r){
            if(l == m)return Math.min(nums[l], nums[r]);
            if((nums[l] > nums[r] && nums[m] < nums[r]) || (nums[l] < nums[m] && nums[m] < nums[r])) r = m;
            else l = m;
            
            m = (r + l) / 2;
        }
        
        return nums[m];
    }
}