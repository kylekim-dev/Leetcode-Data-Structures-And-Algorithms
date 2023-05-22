class Solution {
    public boolean isValidSudoku(char[][] board) {
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
    }
}