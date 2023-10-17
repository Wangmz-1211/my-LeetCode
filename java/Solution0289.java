class Solution {
    /**
     * define some state for under updated cells:
     * - 0 : dead cell
     * - 1 : live cell
     * - 2 : deading cell, can be seen as live cell(1)
     * - 3 : reviving cell, can be seen as dead cell(0)
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {
                int sur = surviveNumber(board, i, j);
                if(board[i][j] == 0 && sur == 3) board[i][j] = 3;
                if(board[i][j] == 1 && (sur < 2 || sur > 3)) board[i][j] = 2;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    /**
     * Return the number of survive cell around the target cell.
     * @param board the whole board
     * @param x the row number of the target cell
     * @param y the col number of the target cell
     * @return the number of survive cell around the target cell (1 | 2)
    */
    private int surviveNumber(int[][] board, int x, int y ){
        int m = board.length, n = board[0].length;
        int ans = 0;
        int row = x-1, col = y-1;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        col ++;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        col ++;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        row ++; col -=2 ;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        col = y+1;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        row ++;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        col --;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        col --;
        if(row >= 0 && row <m && col >= 0 && col <n &&
            (board[row][col] == 1 || board[row][col] == 2)) ans ++;
        return ans;
    }
}
