class Solution {
    public int candy(int[] ratings) {
        /*
        There is three base condition in a sequesce:
        1. upward trend
        2. downward trend
        3. stay
        
        In this question, when condition 1 and 3, the candy of the kid can
        be decided immediately, but in condition 2, we cannot decide the
        candy until we confirm where the downward trend stops. That's why we
        need to pointers for this solution: for the downward trend. 

        The solution are as below:
        1. We need a list to store the candy number
        2. We need two pointers to store the operating subsequence
        3. Metting condition 1 and 3, just calculate the number and move
           the window(two pointer)
        4. Meeting condition 2, we cannot move pointer left until the
           downward trend stops:
           - condition 1
           - condition 3
           Then we need to calculate candy for everyone between pointers,
           except for the kid on the right pointer, because he/she is out of
           the downward trend.
           Then we need to re-confirm the kid on the left pointer, because
           he/she may also the right edge of a upward trend, we need a bigger
           number for him/her.
        5. When the process stops, the calculation of candy number may not
           stop, check it again. 
        
        */
        int n = ratings.length;
        if(n == 1) return 1;
        // step 1
        int[] cd = new int[n];
        for(int i = 0; i < n; i ++) cd[i] = 1;
        // step 2
        int pl = 0, pr = 1;
        boolean down = false;
        while(pr < n){
            if( ratings[pr] > ratings[pr-1]){
                // step 4.2
                if(down) {
                    for(int j = pr -2; j > pl; j--){
                        cd[j] = cd[j+1] + 1;
                    }
                    cd[pl] = Math.max(cd[pl], cd[pl+1]+1);
                    down = false;
                    pl = pr-1;
                    continue;
                }
                // step 3
                cd[pr] = cd[pl] + 1;
                pr++;
                pl++;
                continue;
            }
            if( ratings[pr] == ratings[pr-1]){
                // step 4.2
                if(down){    
                    for(int j = pr -2; j > pl; j--){
                        cd[j] = cd[j+1] + 1;
                    }
                    cd[pl] = Math.max(cd[pl], cd[pl+1]+1);
                    down = false;
                    pl = pr-1;
                    continue;
                }
                // step 3
                cd[pr] = 1;
                pl++;
                pr++;
                continue;
            }
            // step 4.1
            if( ratings[pr] < ratings[pr-1]){
                down = true;
                pr++;
                continue;
            }
        }
        // step 5
        if(down){
            for(int j = pr -2; j > pl; j--){
                cd[j] = cd[j+1] + 1;
            }
            cd[pl] = Math.max(cd[pl], cd[pl+1]+1);
        }
        int ans = 0;
        for(int num: cd){
            ans += num;
        }
        return ans;
    }
}
