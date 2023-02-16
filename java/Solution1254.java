class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n < 3 || m < 3) return 0;
        int res = 0;
        for(int i= 1 ; i< n -1; i++){
            for(int j=1; j< m-1; j++) {
                if(grid[i][j] == 0) res += check(grid,i,j,n,m)?1:0;
            }
        }
        return res;
    }
    private boolean check(int[][] grid, int i, int j, int n, int m){
        if( i<0||j<0||i>=n||j>=m) return false;
        if( grid[i][j] == 1 || grid[i][j] == 2) return true;
        if( i==0||j==0||i==n-1||j==m-1) return false;
        grid[i][j] = 2;
        boolean b1 = check(grid,i-1,j,n,m);
        boolean b2 = check(grid,i+1,j,n,m);
        boolean b3 = check(grid,i,j-1,n,m);
        boolean b4 = check(grid,i,j+1,n,m);
        return  b1&&b2&&b3&&b4;
    }
}
