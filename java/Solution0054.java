class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int direction = 0;
        int x = 0, y = 0;
        for( int i = 0 ; i < m*n ; i++ ){
            switch(direction){
                case 0:
                    if(0 <= x && x < m && 0 <= y && y < n && matrix[x][y]!= -101) {
                        ans.add(matrix[x][y]);
                        matrix[x][y] = -101;
                        y++;
                    } else {
                        direction = 1;
                        y--;
                        x++;
                        i--;
                    }
                    break;
                case 1:
                    if(0 <= x && x < m && 0 <= y && y < n && matrix[x][y]!= -101) {
                        ans.add(matrix[x][y]);
                        matrix[x][y] = -101;
                        x++;
                    } else {
                        direction = 2;
                        x--;
                        y--;
                        i--;
                    }
                    break;
                case 2:
                    if(0 <= x && x < m && 0 <= y && y < n && matrix[x][y]!= -101) {
                        ans.add(matrix[x][y]);
                        matrix[x][y] = -101;
                        y--;
                    } else {
                        direction = 3;
                        x--;
                        y++;
                        i--;
                    }
                    break;
                case 3:
                    if(0 <= x && x < m && 0 <= y && y < n && matrix[x][y]!= -101) {
                        ans.add(matrix[x][y]);
                        matrix[x][y] = -101;
                        x--;
                    } else {
                        direction = 0;
                        x++;
                        y++;
                        i--;
                    }
                    break;
            }
        }
        return ans;
    }
}
