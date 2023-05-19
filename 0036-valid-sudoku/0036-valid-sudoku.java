class Solution {
    /*
        row:
            { 1, [5, 3, 7] }
            { 2, [6, 1, 9, 5] }
        col:
            { 1, [5, 6, 8, 4, 7] }
        rec:
            { 0, [5, 6, 9, 8] }
    
    */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> sq = new HashMap<>();
        int key = 0;
        int sqIndex = 0;
        
        for(int i = 0; i < 9; i++){
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            sq.put(i, new HashSet<>());
        }
        
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                
                if(board[r][c] != '.'){
                    key = board[r][c];
                    sqIndex = (r / 3) * 3 + (c / 3);
                    
                    if(row.get(r).contains(key) || col.get(c).contains(key) || sq.get(sqIndex).contains(key)){
                        return false;
                    }
                    
                    row.get(r).add(key); 
                    col.get(c).add(key); 
                    sq.get(sqIndex).add(key);
                }
            }
        }
        
        return true;
    }
}