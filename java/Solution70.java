class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int climbStairs(int n) {
        map.put(1, 1);map.put(2, 2);
        return process(n);
    }
    private int process(int n){
        if(map.containsKey(n)) return map.get(n);
        else {
            int value = process(n-1) + process(n-2);
            map.put(n, value);
            return value;
        }
    }
}
