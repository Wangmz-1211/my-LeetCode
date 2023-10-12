class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = 0, col = 0;
        boolean[] flag = new boolean[9];
        // check cols
        for(col = 0; col < 9; col ++) {
            // initialize flag
            for(row = 0; row < 9; row++) flag[row] = false;
            for(row = 0; row < 9; row++) {
                if(board[row][col] == '.') continue;
                else {
                    if(flag[board[row][col] -'1']) return false;
                    flag[board[row][col] -'1'] = true;
                }
            }
        }
        // check rows
        for(row = 0; row < 9; row ++) {
            // initialize flag
            for(col = 0; col < 9; col++) flag[col] = false;
            for(col = 0; col < 9; col ++) {
                if(board[row][col] == '.') continue;
                else {
                    if(flag[board[row][col]-'1']) return false;
                    flag[board[row][col]-'1'] = true;
                }
            }
        }
        // check grids
        int x = 0, y = 0;
        for(x = 0; x < 3; x ++) {
            for(y = 0; y < 3; y ++) {
                // initialize flag
                for(col = 0; col < 9; col++) flag[col] = false;
                for(col = x*3; col < x*3 + 3; col++) {
                    for(row = y*3; row < y*3 + 3; row ++) {
                        if(board[row][col] == '.') continue;
                        else {
                            if(flag[board[row][col]-'1']) return false;
                            flag[board[row][col]-'1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
