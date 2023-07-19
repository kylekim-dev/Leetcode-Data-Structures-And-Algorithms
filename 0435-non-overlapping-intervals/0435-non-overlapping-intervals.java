class Solution {
    /*
        Algorithm & DS: Greedy
        Time: O(N*LogN), Space: O(1)
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int nextStart = Integer.MIN_VALUE;
        
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            
            if(start >= nextStart){
                nextStart = end;
            }
            else {
                ans++;
            }
        }
        
        return ans;
    }
}