class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length, k=m*n;
        int[] flag = new int[k];
        int time = 0;
        // 1. 确定存在新鲜橘子，并将烂橘子放入flag中，记录长度
        int pf =0 , ps=0;
        boolean hasFresh = false;
        for(int i= 0; i< m; i++){
            for(int j=0; j< n; j++){
                if(grid[i][j]==1) hasFresh = true;
                if(grid[i][j]==2) {
                    flag[pf++] = i*n + j;
                }
            }
        }
        // 没有新鲜橘子
        if(!hasFresh) return 0; 
        // 没有烂橘子
        if(pf == ps) return -1;
        // 2. 循环对记录下来的橘子进行感染，直到不继续感染
        while(ps<pf){
            int tmp = pf;
            while(ps<tmp) {
                int cur = flag[ps++];
                int i = cur/n;
                int j = cur%n;
                if(j-1>= 0 && grid[i][j-1]==1) {
                    grid[i][j-1] = 2;
                    flag[pf++]=cur-1;
                }
                if(cur-n>=0 && grid[i-1][j]==1) {
                    grid[i-1][j]=2;
                    flag[pf++]=cur-n;
                }
                if(j+1<n && grid[i][j+1]==1) {
                    grid[i][j+1]=2;
                    flag[pf++]=cur+1;
                }
                if(cur+n<k && grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    flag[pf++]=cur+n;
                }
            }
            time++;
        }
        // 3. 如果还有新鲜橘子，一定永远不腐烂
        for(int i= 0; i< m; i++){
            for(int j=0; j< n; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time-1;
    }
}
