class Solution {

    public int fib(int n) {
        int[] fibs = {0, 1, 1};
        
        if (n == 0) return fibs[0];
        if (n == 1) return fibs[1];

        for (int i = 0; i < n-1; i++) {
            fibs[2] = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fibs[2];
        }
        return fibs[2];
    }
}
