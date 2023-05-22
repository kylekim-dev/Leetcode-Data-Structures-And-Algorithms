class Solution {
    public boolean checkValid(int[][] matrix) {
        HashSet<Integer> rows;
        HashSet<Integer> cols;
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            rows = new HashSet<>();
            cols = new HashSet<>();
            
            for(int j = 0; j < n; j++){
                
                if(rows.contains(matrix[i][j]) || cols.contains(matrix[j][i]))  return false;
                
                rows.add(matrix[i][j]);
                cols.add(matrix[j][i]);
            }
        }
        
        
        return true;
    }
}