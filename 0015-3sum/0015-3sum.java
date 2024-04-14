class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * Algorithms & DS: #Two Pointer, #HashMap
         * Time: O(N^2), Extra Space: O(N)
         */
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> checker = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++){
            int a = nums[i];
            HashSet<Integer> set = new HashSet<>();

            for(int j = i + 1; j < nums.length; j++){
                int b = nums[j];
                if(set.contains(-b)){
                    int[] temp = {a, b, -(a + b)};
                    Arrays.sort(temp);
                    String tempStr = Arrays.toString(temp);

                    if(!checker.contains(tempStr)){
                        checker.add(tempStr);
                        ans.add(Arrays.asList(temp[0], temp[1], temp[2]));
                    }
                }

                set.add(a + b);
            }
        }
        
        return ans;
    }
}