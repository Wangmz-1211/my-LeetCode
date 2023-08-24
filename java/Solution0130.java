class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] shadow = new int[m][n];
        for(int x = 0; x< m; x++){
            if(board[x][0] == 'O'){
                fill(board, shadow, x, 0, m, n);
            }
            if(board[x][n-1] == 'O'){
                fill(board, shadow, x, n-1, m, n);
            }
        }
        for(int y = 0; y< n; y++){
            if(board[0][y] == 'O'){
                fill(board, shadow, 0, y, m, n);
            }
            if(board[m-1][y] == 'O'){
                fill(board, shadow, m-1, y, m, n);
            }
        }
        for(int x = 0; x < m; x ++){
            for(int y = 0; y< n; y++){
                if(board[x][y]== 'O' && shadow[x][y] == 0){
                    board[x][y] = 'X';
                }
            }
        }
    }
    private void fill(char[][] board, int[][] shadow, int x, int y, int m, int n){
        if(
            x < 0
            ||
            y < 0
            ||
            x >= m
            ||
            y >= n
        ) return;
        if( board[x][y] == 'O' && shadow[x][y]==0) {
            shadow[x][y] = 1;
            fill(board, shadow, x+1, y, m, n);
            fill(board, shadow, x-1, y, m, n);
            fill(board, shadow, x, y+1, m, n);
            fill(board, shadow, x, y-1, m, n);
        }
        
    }
}
