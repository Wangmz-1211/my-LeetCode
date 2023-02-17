class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        for (int i = 0 ; i < m; i++ ){
            for (int j = 0;  j < n ; j++) {
                if (grid2[i][j]==1) {
                    count+=check(grid1,grid2,m,n,i,j)?1:0;
                }
            }
        }
        return count;
    }
    private boolean check(int[][] grid1, int[][] grid2, int m, int n, int i, int j){
        if( i < 0
            ||
            j < 0
            ||
            i >= m
            ||
            j >= n
            ||
            grid2[i][j] == 0) return true;
        if( grid1[i][j] == 0) return false;
        grid2[i][j]=0;
        boolean b1 = check( grid1, grid2, m, n, i-1, j); 
        boolean b2 = check( grid1, grid2, m, n, i+1, j); 
        boolean b3 = check( grid1, grid2, m, n, i, j-1); 
        boolean b4 = check( grid1, grid2, m, n, i, j+1); 
        return b1&&b2&&b3&&b4;
    }
}
