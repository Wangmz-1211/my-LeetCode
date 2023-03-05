class Solution {
    // shi shan
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        int[] check = new int[size*size];
        int pf = 0, ps = 0;

        int res = 0;
        for(int city = 0; city < size; city ++){
            // once counted city
            if( isConnected[city][city] == 0){
                continue;
            }
            isConnected[city][city] = 0;
            res ++;
            // static connected city
            for(int connect=city+1; connect< size; connect++){
                if(isConnected[city][connect]==1){
                    check[pf++] = connect;
                }
                while(pf > ps){
                    int cityIndex = check[ps++];
                    if(isConnected[cityIndex][cityIndex]==0) continue;
                    isConnected[cityIndex][cityIndex] = 0;
                    for(int i =0; i< size; i++){
                        if(isConnected[cityIndex][i]==1){
                            check[pf++] = i;
                        }
                    }
                }
            }
        }
        return res;
    }
}
