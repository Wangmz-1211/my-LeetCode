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
    /**append all(<=8) nearest nodes to queue*/
    private void appendAll(int[][] grid, int i, int j){
        for(int z = 0; z< 8; z++){
            int tmp = getValue(grid, i+di[z], j+dj[z]);
            if( tmp == 0) queue.offer(new Node(i+di[z], j+dj[z]));
        }
    }
}
