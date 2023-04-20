class Solution {
    /*
        예시
        p1: maxQ: [3] historyQ: [-1]
        p2: maxQ: [3] historyQ: [-1]
        p3: maxQ: [5] historyQ: []
        p4: maxQ: [5] historyQ: [3]
        p5: maxQ: [6] historyQ: []
        p5: maxQ: [7] historyQ: []
        
        아이디어
            해당 게임을 자세히 들여다보면 간단한 규칙이 있음을 알 수 있다.
            [1 3 -1]라는 윈도우를 보자
            1은 자신보다 큰 숫자인 3에 의해 1은 필요 없게 된다.
            -1또한 3에의해 필요없게된다.
            그러나 -1은 3보다 오른쪽에 위치해있기때문에 3이 윈도우 밖으로 나가는 시점에 필요하기때문에,
            언젠간 필요하게된다. (1은 3보다 왼쪽에 있기에.. 영원히 사용할 일이 없다)
            그러므로 -1은 버리지 않고 historyQ에 보관하도록하자.
            이를 dequeue를 사용해서 구현해보자.
            
        알고리즘
            슬라이딩 윈도우
        시간복잡도
            O(N)
        
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] maxs = new int[nums.length - k + 1];
        int l, r;
        
        l = r = 0;
        
        while(r < k){
            while(!dq.isEmpty() && dq.getLast() < nums[r]){
                dq.removeLast();
            }
            dq.addLast(nums[r]);
            
            r += 1;
        }
        
        maxs[l] = dq.getFirst();
        
        while(r < nums.length){
            
            while(!dq.isEmpty() && dq.getLast() < nums[r]){
                dq.removeLast();
            }
            
            dq.addLast(nums[r]);
            
            if(dq.getFirst() == nums[l]){
                dq.removeFirst();
            }
            
            l += 1;
            r += 1;
            
            maxs[l] = dq.getFirst();
        }
        
        return maxs;
    }
}