class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int nextNumber = 0, bit = 0;
        while (n > 1) {
            if (!set.add(n)) return false;
            // calculate next n
            nextNumber  = 0;
            while( n > 0) {
                bit = n % 10;
                nextNumber += Math.pow(bit, 2);
                n /= 10;
            }
            n = nextNumber;
        }
        return n == 1;
    }
}
