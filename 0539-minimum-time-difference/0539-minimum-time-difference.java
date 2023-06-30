class Solution {
    /*
    
           23:01, 00:00, 01:00 => 59
           
           
           오른쪽으로 돌렸을때 비교
           왼쪽으로 돌렸을때 비교
           
           23:50 => 60 * 23 + 50 = 00:10 
           00:00 => 60 * 0 + 00  //
           2:10 => 60 * 2 + 10   //2:20
           
           
           23:50 - 2:10 = (60*23 + 50) - (60*2 + 10) =  1430 - 130 = 1300
           
           24:00 - 2:20
           
           26 % 24, 40 % 60 = 2:20
           
           
           
           0 1 2 3 ... 720 ... 1440
           
           
           300
           
           파이의 총 넓이 1440
           
           Math.min(sizeA, 1440 - sizeA)
    */
    public int findMinDifference(List<String> timePoints) {
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