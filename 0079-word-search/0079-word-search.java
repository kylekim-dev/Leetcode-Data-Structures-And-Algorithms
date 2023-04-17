class Solution {

    private char[][] _board;
    private boolean[][] visit;
    private String _word;
    private int[] dx = { 0, 0, 1, 0, -1 };
    private int[] dy = { 0, -1, 0, 1, 0 };

    public boolean bfs(int depth, int x, int y){
        if(depth == _word.length()){
            return true;
        }

        boolean result = false;

        for(int i = 0; i < dx.length; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= _board[0].length || nextY >= _board.length || visit[nextY][nextX]){
                continue;
            }

            visit[nextY][nextX] = true;

            if(_board[nextY][nextX] == _word.charAt(depth)){
                result = result || bfs(depth + 1, nextX, nextY);
            }

            visit[nextY][nextX] = false;
        }

        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        _board = board;
        _word = word;
        visit = new boolean[board.length][board[0].length];

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[y].length; x++){
                if(bfs(0, x, y))
                    return true;
            }
        }

        return  false;
    }
}