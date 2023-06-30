class Solution {
    /*
        total minutes = hour * 60 + minutes
        00:00 = 0
        00:01 = 1
        01:01 = 61
        ...
        23:59 = 1439
        
        
            0
            
        18      6
        
            12
            
            
        diff[i] = Math.min(시계 방향순으로 차이, 시계 반대반향으로 차이)
            
        output = Math.min(diff[0], diff[1], ... diff[i])
                 
    */
    public int findMinDifference(List<String> timePoints) {
        // Algorithm: Math & Sort
        // Time: O(NLogN), Space: O(N)
        
        int output = Integer.MAX_VALUE;
        int[] timeTable = new int[timePoints.size()];
        
        for(int i = 0; i < timePoints.size(); i++){
            String[] hourMin = timePoints.get(i).split(":");
            timeTable[i] = Integer.parseInt(hourMin[0]) * 60 + Integer.parseInt(hourMin[1]);
        }
        
        Arrays.sort(timeTable); // NLogN
        
        for(int i = 0; i < timeTable.length; i++){
            int diff = Math.abs(timeTable[(i + 1) % timeTable.length] - timeTable[i]);
            if(diff > 720) diff = 1440 - diff;
            
            output = Math.min(output, diff);
        }
        
        return output;
    }
}