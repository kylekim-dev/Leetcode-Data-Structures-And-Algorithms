class Solution {
    /*
        1,0 -> 0,1
        2,0 -> 0,2
        
        2,1 -> 1,2
        
        [1,2,3],
        [4,5,6]
        
        1 4
        2 5
        3 6
    */
    
    
    public int[][] transpose(int[][] matrix) {
        int[][] output = new int[matrix[0].length][matrix.length];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                output[c][r] = matrix[r][c];
            }
        }
        
        return output;
    }
}