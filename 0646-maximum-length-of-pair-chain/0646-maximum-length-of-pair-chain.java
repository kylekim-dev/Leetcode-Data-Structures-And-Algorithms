class Solution {
    /*
        Algorithm & DS: Greedy and Sort
        Time: O(NLogN), Space: O(1)
    */
    public int findLongestChain(int[][] pairs) {
        // 시작점 기준으로 내림차순 정렬
        Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        // 끝점 기준으로 내림차순 정렬
        Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int disconnectedCount = 1;
        int prev = 0;

        for(int curr = 1; curr < pairs.length; curr++){
            int prevEnd = pairs[prev][1];
            int currStart = pairs[curr][0];

            // 두개의 체인이 연결되어있지 않으면
            // 다음 체인으로 넘어감
            if(prevEnd < currStart){
                prev = curr;
                disconnectedCount++;
            }
        }

        return disconnectedCount;
    }
}