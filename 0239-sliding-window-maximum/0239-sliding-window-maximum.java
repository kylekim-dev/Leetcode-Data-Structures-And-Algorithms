class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
            Algorithms & DS: Monotonic Queue
            Time: O(N), Extra Space: O(K)
        */
        int[] res = new int[nums.length - k + 1];
        int j = 1 - k;
        Deque<Integer> monoQ = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            while (!monoQ.isEmpty() && nums[monoQ.getLast()] <= nums[i]){
               monoQ.pollLast();
            }

            if (!monoQ.isEmpty() && monoQ.getFirst() <= i - k){
                monoQ.pollFirst();
            }

            monoQ.add(i);

            if(j >= 0) res[j] = nums[monoQ.getFirst()];

            j++;
        }
        
        return res;
    }
}