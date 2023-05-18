class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //  Constraints: 1 <= n <= 10^5
        //  Time: O(N)
        //  Space: O(1)
        List<Integer> result = new ArrayList<>();
        
        for(int n : nums){
            n = Math.abs(n);
            if(nums[n - 1] < 0) result.add(n);
            else nums[n - 1] *= -1;
        }
        
        return result;
    }
    
    /*public List<Integer> findDuplicates(int[] nums) {
        //  Brute-Force
        //  Time: O(N)
        //  Space: O(N)
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            if(set.contains(n)) result.add(n);
            else set.add(n);
        }
        
        return result;
    }*/
}