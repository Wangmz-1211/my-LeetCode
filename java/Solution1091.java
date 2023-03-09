/*
class Solution {
    class Node {
        int i, j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    private Queue<Node> queue = new LinkedList<>();
    private int[] di = {+1,+1, 0, -1, -1, -1, 0, +1};
    private int[] dj = {0, +1, +1, +1, 0, -1, -1, -1};
    private int m, n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if( grid[0][0]==1) return -1;
        m = grid.length;
        n = grid[0].length;
        Node node = new Node(0, 0);
        queue.offer(node);
        int step = 1;
        while(queue.size()!=0){
            int size = queue.size();
            for(int s= 0; s< size; s++){
                node = queue.poll();
                if (node.i==m-1&&node.j==n-1) return step;
                if (grid[node.i][node.j]==1) continue;
                appendAll(grid, node.i, node.j);
                grid[node.i][node.j]=1;
            }
            step++;
        }
        return -1;
    }
    private int getValue(int[][] grid, int i,int j){
        if(i<0 || i>=m ||j<0 || j>=n) return -1;
        return grid[i][j];
    }
    //append all(<=8) nearest nodes to queue
    private void appendAll(int[][] grid, int i, int j){
        for(int z = 0; z< 8; z++){
            int tmp = getValue(grid, i+di[z], j+dj[z]);
            if( tmp == 0) queue.offer(new Node(i+di[z], j+dj[z]));
        }
    }
}
*/
class Solution {

    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n; // size of matrix
        if( grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        // initialize the queue
        int[] xQueue = new int[size];
        int[] yQueue = new int[size];
        // position of the queue
        int pf = 1, ps = 0;
        // position of the matrix
        int x = 0 , y = 0;
        int length = 0;
        while(ps < pf){
            size = pf - ps; // size of the layer
            length ++;
            for(int i =0; i< size; i++){
                // queue poll
                x = xQueue[ps];
                y = yQueue[ps++];
                // blocked
                if(grid[x][y]==1){
                    continue;
                }
                // reach the destination
                if(x == m-1 && y == n-1){
                    return length;
                }
                grid[x][y] = 1;
                // get the next layer
                for(int rotation = 0; rotation<8; rotation++){
                    int xtmp = x + dx[rotation];
                    int ytmp = y + dy[rotation];
                    int vtmp = getValOfTheMatrix(grid, xtmp, ytmp);
                    if(vtmp == 0){
                        grid[xtmp][ytmp] = 2;   // so that it won't be offer into queue again
                        // queue offer
                        xQueue[pf] = xtmp;
                        yQueue[pf++] = ytmp;
                    }  
                }
            }
        }
        // not connected
        return -1;
    }
    private int getValOfTheMatrix(int[][]grid, int x, int y){
        int m = grid.length, n = grid[0].length;
        if( x < 0
            ||
            y < 0
            ||
            x >= m
            ||
            y >= n) return -1;
        else return grid[x][y];
    }
}
