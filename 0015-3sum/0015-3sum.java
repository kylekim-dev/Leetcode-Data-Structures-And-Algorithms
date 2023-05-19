class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> check = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            HashSet<Integer> set = new HashSet<>();
            
            for(int j = i + 1; j < nums.length; j++){
                int b = (nums[i] + nums[j]) * -1;
                
                if(set.contains(b)){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(b);
                    Collections.sort(arr);
                    String str = arr.toString();
                    
                    if(!check.contains(str)){
                       result.add(arr);
                       check.add(str);
                    }
                        
                }
                
                set.add(nums[j]);
            }
        }
        
        
        return result;
    }
}