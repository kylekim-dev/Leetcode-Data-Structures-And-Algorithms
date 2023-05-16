class Solution {
    /*
        Time: 6m 42s
        
        아이디어
            - A + B = Target
            - 해쉬 테이블 사용
            - Map<B, index of A>
            
        시간복잡도
            T: O(N)
            S: O(N)
            
        자료구조
            해쉬 맵
    
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) 
                return new int[]{ map.get(nums[i]), i};
            
            map.put(target - nums[i], i);
        }
        
        return null;
    }
}