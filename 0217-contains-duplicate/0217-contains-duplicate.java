class Solution {
    public boolean containsDuplicate(int[] nums) {

        /*
         * Algorithms & Data Structure: HashSet
         * Time Complexity:  O(N)
         * Space Complexity: O(N)
         */
         HashSet set = new HashSet<Integer>();

         for(int num : nums){
            if(set.contains(num)){
                return true;
            }

            set.add(num);
         }

         return false;
    }
}