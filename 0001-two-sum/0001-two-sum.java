class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                answer[0] = map.get(nums[i]);
                answer[1] = i;
                return answer;
            }
            
            map.put(target - nums[i], i);
        }
        
        return answer;
    }
}