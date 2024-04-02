class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            Algorithms & DS: #Hashing
            Time: O(N), Space: O(N)
         */

         HashMap<Integer, Integer> map = new HashMap<>();

         for(int i = 0; i < nums.length; i++){
             int curr = nums[i];
             int wanted = target - curr;
             if(map.containsKey(curr)){
                 return new int[]{ map.get(curr), i};
             }

             map.put(wanted, i);
         }
        
        return null;
    }
}