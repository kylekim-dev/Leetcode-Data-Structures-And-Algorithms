class Solution {
    /*
        Algorithm & DS: HashMap
        Time: O(N), Space: O(N)
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