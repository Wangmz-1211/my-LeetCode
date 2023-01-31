class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int order = grid.length ;
        for (int colomn = 0; colomn < order ; colomn ++ ) {
            for (int row = 0; row< order; row ++) {
                if ( row == colomn ||
                     row + colomn == order -1) {
                        if (grid[colomn][row] == 0) return false;
                     }
                else if (grid[colomn][row] != 0 ) return false;
            }
        }
        return true;
    }
    
}
