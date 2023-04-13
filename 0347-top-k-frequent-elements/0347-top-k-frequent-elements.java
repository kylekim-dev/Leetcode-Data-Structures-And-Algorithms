class Solution {
    /*
        [1,1,1,3,2,2,3,3]
        
        1, 3
        
    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1].compareTo(o1[1]));
        // O(N)
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key:map.keySet()) {
            pq.offer(new Integer[]{key, map.get(key)});
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        
        return result;
    }
}