class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length + 1 - k];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(nums[o2], nums[o1]));
        int l = 0, r = 0;

        while (r < nums.length){
            maxHeap.offer(r);
            if(r >= k - 1){
                while (!maxHeap.isEmpty() && maxHeap.peek() < l){
                    maxHeap.poll();
                }

                output[l] = nums[maxHeap.peek()];
                l++;
            }
            r++;
        }
        
        return output;
    }
}