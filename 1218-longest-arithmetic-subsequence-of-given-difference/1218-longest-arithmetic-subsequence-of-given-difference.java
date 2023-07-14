class Solution {
    /*
        arr = [1,5,7,8,5,3,4,2,1], difference = -2
        
        
    
    */
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int num : arr){
            int target = num + difference; 
            int count = map.getOrDefault(num, 0) + 1;

            if(count > map.getOrDefault(target, 0)) {
                map.put(target, count);
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}