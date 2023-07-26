class Solution {
    double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0 ; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            // Round off to the next integer, if not the last ride.
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }
    
    /*
        Algorithm & DS: Binary Search
        Time: O(N LogN), Space: O(1)
    */
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10000000;
        int min = -1;
        while(l <= r){
            int m = (r + l) / 2;
            
            if(timeRequired(dist, m) <= hour) {
                min = m;
                r = m - 1;   
            }
            else l = m + 1;
        }
        
        return min;
    }
}