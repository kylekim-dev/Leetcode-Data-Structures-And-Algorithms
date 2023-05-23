class Solution {
    /*
        row:
            { 1, [5, 3, 7] }
            { 2, [6, 1, 9, 5] }
            ...
            { 9, [8, 7, 9]}
        col:
            { 1, [5, 6, 8, 4, 7] }
            { 2, [3, 9, 6] }
            ...
            { 9, [3, 1, 6, 5, 9] }
        rec:
            { 1, [5, 6, 9, 8] }
            { 2, [7, 1, 9, 5] }
            ...
            { 9, [2, 8, 5, 7, 9] }
    
    */
    public boolean isValidSudoku(char[][] board) {
        // Algorithm: HashMap, HashSet
        // Time: O(N^2), Space: O(N^2), N = 9
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
    /*public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        int section = 0;
        
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] != '.'){
                    String row = "r" + r + board[r][c];
                    String col = "c" + c + board[r][c];
                    String sq = "s" + (r / 3) * 3 + (c / 3) + board[r][c];
                    
                    if(set.contains(row) || set.contains(col) || set.contains(sq)) return false;
                    
                    set.add(row);
                    set.add(col);
                    set.add(sq);
                }
            }
        }
        
        return true;
    }*/
}