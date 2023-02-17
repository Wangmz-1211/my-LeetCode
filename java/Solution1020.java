class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if( m< 3 || n< 3) return 0;
        for (int i = 0; i <m ; i++ ){
            if( grid[i][0] == 1) floodFill(grid, i, 0, m, n);
            if( grid[i][n-1]==1) floodFill(grid, i, n-1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if( grid[0][j] == 1) floodFill(grid, 0, j, m, n);
            if( grid[m-1][j] ==1) floodFill(grid, m-1 ,j, m,n);
        }
        int count = 0;
        for (int i = 1; i< m - 1; i++){
            for (int j =1; j< n- 1; j++){
                if(grid[i][j] == 1) count ++; 
            }
        }
        return count;
    }
    private void floodFill(int[][] grid, int sc, int sr, int m , int n){
        if( sc < 0
            ||
            sc >= m
            ||
            sr < 0
            ||
            sr >= n
            ||
            grid[sc][sr] != 1 ) return;
        grid[sc][sr] = 0;
        floodFill(grid, sc -1, sr, m, n);
        floodFill(grid, sc +1, sr, m, n);
        floodFill(grid, sc, sr -1, m, n);
        floodFill(grid, sc, sr +1, m, n);
    }
}
