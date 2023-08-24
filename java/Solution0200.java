class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if (grid[i][j]=='1') {
                    floodFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void floodFill(char[][] grid, int sr, int sc){
        if( sr >= grid.length 
            ||
            sc >= grid[0].length
            ||
            sr < 0
            ||
            sc < 0
            ||
            grid[sr][sc]=='0') return;
        grid[sr][sc] = '0';
        floodFill(grid, sr -1, sc);
        floodFill(grid, sr +1, sc);
        floodFill(grid, sr , sc-1);
        floodFill(grid, sr , sc+1);
    }
}
