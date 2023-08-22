class Solution {
    public int tribonacci(int n) {
        int[] arr = {0, 1, 1, 0};
        if (n == 0) return arr[0];
        if (n == 1) return arr[1];
        if (n == 2) return arr[2];

        for (int i = 0 ; i < n-2; i ++ ) {
            arr[3] = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[3];
        }
        return arr[3];
    }
}
