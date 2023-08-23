class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));

        for(int i = 0; i < nums1.length; i++){
            maxHeap.offer(new Integer[]{nums1[i], nums2[i]});
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sum = 0;

        while (!maxHeap.isEmpty()){
            while (minHeap.size() < k){
                Integer[] curr = maxHeap.poll();
                minHeap.offer(curr);
                sum += curr[0];
                min = curr[1];
            }

            if(max < sum * min) max = sum * min;

            sum -= minHeap.poll()[0];
        }
        return max;
    }
}