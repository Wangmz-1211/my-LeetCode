class Solution {
    public int maximumWealth(int[][] accounts) {
        int tmp = 0 ;
        for (int[] account : accounts) {
            tmp = tmp < sumWealth(account)? sumWealth(account): tmp;
        }
        return tmp;
    }
    public int sumWealth(int[] account) {
        int sum = 0 ;
        for (int n : account) sum += n;
        return sum ;
    }
}
