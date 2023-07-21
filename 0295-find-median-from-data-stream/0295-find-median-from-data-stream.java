class MedianFinder {
    /*
        Algorithm & DS: Priority Queue
        Time: O(LogN), Space: O(N)
    */
    
    private PriorityQueue<Double> ascendingQueue = new PriorityQueue<>();
    private PriorityQueue<Double> descendingQueue = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    private boolean isEven = true;
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(isEven){
            ascendingQueue.offer((double)num);
            descendingQueue.offer(ascendingQueue.poll());
        }
        else {
            descendingQueue.offer((double)num);
            ascendingQueue.offer(descendingQueue.poll());
        }
        
        isEven = !isEven;
    }
    
    public double findMedian() {
        return isEven ? (ascendingQueue.peek() + descendingQueue.peek()) / 2 : descendingQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */