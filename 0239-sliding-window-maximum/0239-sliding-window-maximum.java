class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int left, right;
        left = 0;

        for(right = 0; right < k; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        }

        while (right < nums.length){
            max[left] = map.firstKey();
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if(map.get(nums[left]) == 1){
                map.remove(nums[left]);
            }
            else {
                map.put(nums[left], map.get(nums[left]) - 1);
            }

            left += 1;
            right += 1;
        }

        max[left] = map.firstKey();

        return max;
    }
}