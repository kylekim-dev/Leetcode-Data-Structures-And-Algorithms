class Solution {
    /*
         0 1 2 3 0 1 0
         0 3 2 1 0 1 0
        [1,0,0,0,1,0,1]
    
    */
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 1; i < n; i++){
            left[i] = seats[i] == 1 ? 0 : left[i - 1] + 1;
        }
        
        for(int i = n - 2; i >= 0; i--){
            right[i] = seats[i] == 1 ? 0 : right[i + 1] + 1;
        }
        
        if(seats[0] == 0) left[0] = right[0];
        if(seats[n - 1] == 0) right[n - 1] = left[n - 1];
        int maximumDistance = 0;
        
        for(int i = 0; i < n; i++){
            maximumDistance = Math.max(maximumDistance, Math.min(left[i], right[i]));
        }
        
        return maximumDistance;
    }
}