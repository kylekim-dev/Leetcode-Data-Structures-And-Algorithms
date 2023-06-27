class Solution {
    /*
        [1950,1961],
        [1970,1981],
        [1960,1971],
        
        1950            1961
        [1, 0, 0 ... 0, -1]
        
                                1970            1981
                                [1, 0, 0 ... 0, -1]
    */
    public int maximumPopulation(int[][] logs) {
        // Algorithm & DS: Accumulate Sum
        // Time: O(N + 100) Space: O(100)
        
        int start = 1950, end = 2050;
        int[] accumulate = new int[end - start + 1];
        int populationYear = 0;
        
        for(int i = 0; i < logs.length; i++){
            int birth = logs[i][0], depth = logs[i][1];
            accumulate[birth - start] += 1;
            accumulate[depth - start] -= 1;
        }
        
        for(int i = 1; i < accumulate.length; i++){
            accumulate[i] += accumulate[i - 1];
            
            if(accumulate[populationYear] < accumulate[i]) populationYear = i;
        }
        
        return populationYear + start;
    }
}