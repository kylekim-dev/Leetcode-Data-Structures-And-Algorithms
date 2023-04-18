class Solution {
    public int jump(int[] nums) {
        int[] min = new int[nums.length];
        int r = nums.length - 1;

        nums[r] = 0;
        r -= 1;

        while (r > -1){
            int localMin = 10000;

            for(int i = 1; i <= nums[r]; i++){
                if(r + i >= min.length){
                    break;
                }
                localMin = Math.min(localMin, min[r + i]);
            }

            min[r] = localMin + 1;
            r -= 1;
        }

        return min[0];
    }
}