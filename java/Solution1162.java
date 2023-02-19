class Solution {
    public int maxDistance(int[][] grid) {
        // dao
        class Node{
            int i, j;
            public Node(int i,int j){
                this.i = i;this.j = j;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        int tmp = grid[0][0];
        int m = grid.length, n= grid[0].length;
        // check all island or sea
        boolean flag = true;
        for (int i=0; i<m; i++){
            for (int j=0; j<n ;j++){
                if(grid[i][j]!=tmp) {
                    flag=  false;
                    break;
                }
            }
            if(!flag) break;
        }
        // process
        if(flag) return -1;
        for (int i = 0 ; i< m; i++){
            for ( int j=0; j< n; j++){
                if(grid[i][j]==1) {
                    queue.offer(new Node(i,j));
                }
            }
        }
        int step = 0;
        while(queue.size()>0){
            step ++;
            int size = queue.size();
            while(size-->0){
                Node t = queue.poll();
                int i = t.i, j=t.j;
                if( i-1>=0 && grid[i-1][j]==0) {
                    grid[i-1][j] = step;
                    queue.offer(new Node(i-1,j));
                }
                if( i+1<m && grid[i+1][j]==0) {
                    grid[i+1][j] = step;
                    queue.offer(new Node(i+1,j));
                }
                if( j-1>=0 && grid[i][j-1]==0) {
                    grid[i][j-1] = step;
                    queue.offer(new Node(i,j-1));
                }
                if( j+1<n && grid[i][j+1]==0) {
                    grid[i][j+1] = step;
                    queue.offer(new Node(i,j+1));
                }
            } 
        }
        return step-1;
    }
}
