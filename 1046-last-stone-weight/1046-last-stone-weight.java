class Solution {
    /*
        [2,7,4,1,8,1]
        
        8,7,4,2,1,1
        
        4 2 1 1 1
        2 1 1 1
        1 1 1
        1
        
    
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        
        for(int stone : stones) heap.add(stone);
        
        while(heap.size() > 1) heap.add(heap.poll() - heap.poll());
        
        return heap.poll();
    }
}