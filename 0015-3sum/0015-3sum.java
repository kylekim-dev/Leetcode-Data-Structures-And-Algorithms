class Solution {
    // Algorithm & DS: Two Pointers
    // Time: O(n^2), Extra Space: O(1)
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(N*LogN)

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l += 1;
                    while (nums[l] == nums[l - 1] && l < r){
                        l++;
                    }
                }
            }
        }
        
        return res;
    }
}