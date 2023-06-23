class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] output = new int[k];
        
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1); //{ 1:3, 2:2, 3:1 }
            max = Math.max(max, count.get(num));
        } 
        
        List<List<Integer>> bucketSort = new ArrayList<>();
        
        for(int i = 0; i <= max; i++) bucketSort.add(new ArrayList<>());
        
        count.forEach((key, value) -> {
            List<Integer> list = bucketSort.get(value);
            list.add(key);
        });
        
        
        for(int i = bucketSort.size() - 1; i >= 0; i--){
            List<Integer> list = bucketSort.get(i);
            
            for(int num : list){
                output[--k] = num;
                if(k <= 0) return output;
            }
        }
        
        return output;
    }
}