class Solution {
    class Node{
            int i, j;
            public Node(int i, int j){
                this. i = i;
                this. j = j;
            }
        }
    Queue<Node> queue = new LinkedList<>();
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n=mat[0].length;
        int[] dx = {+1, 0, -1, 0}, dy = {0, +1, 0, -1};
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) queue.offer(new Node(i,j));
                else mat[i][j]=-1;
            }
        }
        int step = 0;
        while(queue.size()!=0){
            int size = queue.size();
            while(size-->0){
                Node node = queue.poll();
                mat[node.i][node.j] = step;
                for(int z = 0; z< 4; z++){
                    int x = node.i + dx[z], y= node.j + dy[z];
                    if(0<=x && x< m && 0<=y && y<n && mat[x][y]==-1){
                        mat[x][y]= -2;
                        queue.offer(new Node(x, y));
                    } 
                }
            }
            step++;
        }
        return mat;
    }
}
