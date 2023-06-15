class Solution {
    List<List<Integer>> output;
    List<Integer> temp;
    int[] nums;
    boolean[] visit;
    HashSet<String> set;
    
    void backtracking(int depth){
        if(depth == nums.length && !set.contains(temp.toString())){
            output.add(new ArrayList<>(temp));
            set.add(temp.toString());
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visit[i]) continue;
            
            temp.add(nums[i]);
            visit[i] = true;
            backtracking(depth + 1);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.visit = new boolean[nums.length];
        this.temp = new ArrayList<>();
        this.output = new ArrayList<>();
        this.set = new HashSet<>();
        backtracking(0);
        
        return output;
    }
}