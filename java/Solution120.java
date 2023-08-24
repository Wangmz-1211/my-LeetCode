class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for( int i = m-2; i>= 0; i--){
            List<Integer> cur = triangle.get(i);
            List<Integer> nxt = triangle.get(i+1);
            for(int j = 0; j< cur.size(); j++){
                int a = nxt.get(j), b = nxt.get(j+1);
                cur.set(j, cur.get(j)+(a > b? b: a));
            }
        }
        return triangle.get(0).get(0);
    }
}

/**
 * @Date: 2023-8-24
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] matrix = new int[height][height];
        List<Integer> thisRow = triangle.get(0);
        matrix[0][0] = thisRow.get(0);
        // dp
        for (int row = 1; row < height; row++) {
            thisRow = triangle.get(row);
            matrix[row][0] = thisRow.get(0)+matrix[row-1][0];
            for(int i = 1; i < row; i++) {
                int tmp = Math.min(matrix[row-1][i-1], matrix[row-1][i]);
                matrix[row][i] = thisRow.get(i) + tmp;
            }
            matrix[row][row] = thisRow.get(row)+matrix[row-1][row-1];
        }
        System.out.println(Arrays.toString(matrix[height-1]));
        int res = matrix[height-1][0];
        for(int i = 1; i < height; i ++){
            res = matrix[height-1][i] < res ? matrix[height-1][i] : res;
        }
        return res;

    }
}
