class Solution {
    /*
        [10000], 10000 >> 1 best
        
        1, ... 10^9
        1, 5 >> 1999
        1, 3 >> 3000
        1, 2 >> 10000
        1, 1 >> 10000 >> return speed;
        
        
        [10,000], 5,000
        
        1, 5 >> 3 >> 3333
        1, 2 >> 1 >> 10000
        2, 2 >> 2 >> 5000 >> return speed
        
        piles = [30,11,23,4,20], h = 6
        1, 30 
        
    
        [1000], h = 999, output = 2
        1   10^9    50^8
        ...
        1   5   3
        1   2   1
        2   2   2
        
        [1000], h = 1000, output = 1
        1   10^9    50^8
        ...
        1   5   3
        1   2   1
        1   1   1
        
        [30,11,23,4,20], h = 5, output = 30
        1   50  25
        26  50  38
        26  37  31
        26  30  28
        29  30  29
        30  30  30
        
        [30,11,23,4,20], h = 6, 23
        1   50  25
        1   24  12
        13  24  18
        19  24  21
        22  24  23
        22  22  22
        
        [312,884,470]
        968,709,470
        
        
        [2,2], 2
        
        1   5   3
        1   2   1
        2   2   2
        
        [805306368,805306368,805306368]
        1,000,000,000
    */
    
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000001;
        int speed= (r + l) / 2;
        
        while(l < r){
            if(inTime(piles, h, speed)) r = speed - 1;
            else l = speed + 1;
            
            speed = (r + l) / 2;
        }
        
        return inTime(piles, h, speed) ? speed : speed + 1;
    }
    
    boolean inTime(int[] piles, int h, int speed){
        if(speed <= 0) return false;
        
        long totalHour = 0;
        
        for(int i = 0; i < piles.length; i++){
            totalHour += piles[i] / speed;
            if(piles[i] % speed > 0)
                totalHour += 1;
        }
        
        return totalHour <= h;
    }
}