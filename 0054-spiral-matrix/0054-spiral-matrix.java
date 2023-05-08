class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int VISITED = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> output = new ArrayList<>();
        int direction = 0;
        int x, y;
        x = y = 0;

        while (matrix[y][x] != VISITED){
            output.add(matrix[y][x]);
            matrix[y][x] = VISITED;

            for(int i = 0; i < dx.length; i++){
                int nextDirection = (direction + i) % dx.length;
                int nextX = x + dx[nextDirection];
                int nextY = y + dy[nextDirection];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || matrix[nextY][nextX] == VISITED){
                    continue;
                }

                x = nextX;
                y = nextY;
                direction = nextDirection;
                break;
            }
        }

        return output;
    }
}