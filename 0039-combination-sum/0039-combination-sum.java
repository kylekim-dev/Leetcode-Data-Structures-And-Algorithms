class Solution {

    public void recursive(int[] candidates, int target, List<Integer> nums, int sum, int start, List<List<Integer>> output){
        if(sum >= target){
            if(sum == target){
                output.add(new ArrayList<>(nums));
            }
            return;
        }

        for(int i = start; i < candidates.length; i++){
            nums.add(candidates[i]);
            recursive(candidates, target, nums, sum + candidates[i], i, output);
            nums.remove(nums.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int sum = 0;

        Arrays.sort(candidates);

        recursive(candidates, target, nums, sum, 0, output);
        
        return output;
    }
}