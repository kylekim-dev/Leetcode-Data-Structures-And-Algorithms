class KthLargest {
    Queue<Integer> min = new PriorityQueue<Integer>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int n : nums){
            min.add(n);
        }
        
        while(min.size() > k){
            min.poll();
        }
        
        this.k = k;
    }
    
    public int add(int val) {
        min.add(val);
        
        if(min.size() > k){
            min.poll();   
        }
        
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */