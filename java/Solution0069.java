class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        double pre = x;
        double cur = x;
        do { 
            pre = cur;
            cur = (cur*cur + x)/cur/2;
        }while (Math.abs(pre - cur) > 0.5);
        return (int)cur;
    }
}
