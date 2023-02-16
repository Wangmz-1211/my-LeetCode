class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i< grid.length; i++) {
            for(int j= 0; j< grid[i].length; j++){
                if(grid[i][j] == 1) {
                    int tmp = floodFill(grid, i, j);
                    max = max>tmp? max:tmp;
                }
            }
        }
        return max;
    }
    private int floodFill(int[][] grid, int sr, int sc) {
        if (sr < 0
            ||
            sr >= grid.length
            ||
            sc < 0
            ||
            sc >= grid[0].length
            ||
            grid[sr][sc] == 0) return 0;
        grid[sr][sc] = 0;
        return 1 
        + floodFill(grid , sr + 1, sc)
        + floodFill(grid , sr - 1, sc)
        + floodFill(grid , sr, sc + 1)
        + floodFill(grid , sr, sc - 1);
    }
}
