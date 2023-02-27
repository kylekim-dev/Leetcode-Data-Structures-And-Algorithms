class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                indices[0] = map.get(nums[i]);  // prev key
                indices[1] = i;                 // current key
                break;
            }
            
            map.put(target - nums[i], i);
        }

        return indices;
    }
}