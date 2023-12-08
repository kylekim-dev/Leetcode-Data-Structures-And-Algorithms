class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int n : nums){
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> countMap.get(o2).compareTo(countMap.get(o1)));

        for (Integer  n : countMap.keySet()){
            pq.offer(n);
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        
        return res;
    }
}