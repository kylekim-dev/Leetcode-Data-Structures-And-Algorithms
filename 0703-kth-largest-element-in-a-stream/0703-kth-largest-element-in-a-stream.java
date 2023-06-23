class KthLargest {
    /*
        ["KthLargest","add","add","add","add","add"]
        [[1,[]],[-3],[-2],[-4],[0],[4]]
        
        
    */
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) heap.add(num);
        while(heap.size() > k) heap.poll();
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k) heap.poll();
        
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */