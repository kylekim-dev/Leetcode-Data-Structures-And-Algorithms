class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            Algorithms & DS: Binary Search
            Time: O(LogN), Extra Space: O(1)
         */

        int l = 0, r = matrix.length - 1;
        int row = 0;
        int col = 0;

        while (l <= r){
            row = (r + l) / 2;

            if(matrix[row][0] < target) l = row + 1;
            else if(matrix[row][0] > target) r = row - 1;
            else return true;
        }

        if(matrix[row][0] > target && row > 0)
            row--;

        l = 0;
        r = matrix[row].length - 1;

        while (l <= r){
            col = (r + l) / 2;
            if(matrix[row][col] < target) l = col + 1;
            else if(matrix[row][col] > target) r = col - 1;
            else return true;
        }
        
        return false;
    }
}