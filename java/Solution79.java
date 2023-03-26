class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        int m = board.length, n = board[0].length;
        for( int x = 0; x < m; x ++){
            for (int y = 0; y < n; y ++){
                if( board[x][y]==letters[0]){
                    boolean res = find(board, letters, x, y, 0);
                    if(res) return res ; else continue; 
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, char[] word, int x, int y, int cur){
        char tmp = board[x][y];
        board[x][y]= '#';
        int length = word.length;
        if( cur == length-1) return true;
        char target = word[++cur];
        if( getChar(board, x+1, y)== target){
            boolean res = find(board, word, x+1, y, cur);
            if(res) return true;
        }
        if( getChar(board, x-1, y)== target){
            boolean res = find(board, word, x-1, y, cur);
            if(res) return true;
        }
        if( getChar(board, x, y+1)== target){
            boolean res = find(board, word, x, y+1, cur);
            if(res) return true;
        }
        if( getChar(board, x, y-1)== target){
            boolean res = find(board, word, x, y-1, cur);
            if(res) return true;
        }
        board[x][y]= tmp;
        return false;
    }

    private char getChar(char[][] board, int x, int y){
        int m = board.length, n = board[0].length;
        if(
            x < 0
            ||
            y < 0
            ||
            x >= m
            ||
            y >= n
        ) return '#';
        else return board[x][y];
    }
}
