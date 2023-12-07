class Solution {
    /*
        Algorithm & DS: HashSet & Iterator
        Time: O(N^2)
        Space: O(M)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> duplicateChecker = new HashSet<>();
        
        // 첫번째 값을 기준으로 탐색시작
        for(int i = 0; i < nums.length - 2; i++){
            HashSet<Integer> finder = new HashSet<>();
            
            for(int j = i + 1; j < nums.length; j++){
                int c = -(nums[i] + nums[j]); 
                
                if(finder.contains(c)){
                    List<Integer> arr = Arrays.asList(nums[i], nums[j], c);
                    Collections.sort(arr);
                    
                    String key = arr.toString();
                    
                    if(!duplicateChecker.contains(key)){
                       duplicateChecker.add(key);
                       result.add(arr);
                    }
                }
                
                finder.add(nums[j]);
            }
        }
        
        return result;
    }
}