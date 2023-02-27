class Solution {
    public void recursive(int[] nums, int depth, HashSet<Integer> check, List<Integer> permutation, List<List<Integer>> output){
        if(nums.length == depth){
            output.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (check.contains(nums[i])){
                continue;
            }

            check.add(nums[i]);
            permutation.add(nums[i]);
            recursive(nums, depth + 1, check, permutation, output);
            check.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        recursive(nums, 0, new HashSet<>(), new ArrayList<>(), output);

        return output;
    }
}