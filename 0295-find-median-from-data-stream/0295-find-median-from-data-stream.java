class MedianFinder {
    /*
        문제: 여태까지 들어온 숫자들의 중위 값을 구하라
        
        오름차순 우선순위 큐
        내림차순 우선순위 큐
        
        even이면 Peek of (Incresending Queue + Peek of Decresending Queue) / 2
        odd면 Peek of Increasing Queue ??
        
        
        in q: 2
        de q: 10 1
        
        1: f, inQ.poll() = 1
        2: t, deQ + inQ / 2 = 1.5
        3. f, 
            
        
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