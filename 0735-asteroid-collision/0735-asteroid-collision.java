class Solution {
    /*
    
        2 -5 5 10 -5
        
        5 10
        -5
        
        -5 5 10
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> posi = new Stack<>();
        Stack<Integer> nega = new Stack<>(); // -10 -5 -1
        
        for(int i = asteroids.length - 1; i >= 0; i--){
            if(asteroids[i] < 0) nega.push(asteroids[i]);
            else {
                while(!nega.isEmpty() && Math.abs(nega.peek()) < asteroids[i]){
                    nega.pop();
                }
                
                if(nega.isEmpty()) posi.push(asteroids[i]);
                else if(Math.abs(nega.peek()) == asteroids[i]) nega.pop();
            }
        }
        
        int[] output = new int[posi.size() + nega.size()];
        int i = 0;
        
        while(!nega.isEmpty()){
            output[i] = nega.pop();
            i++;
        }
        
        while(!posi.isEmpty()){
            output[i] = posi.pop();
            i++;
        }
        
        return output;
    }
}