class Solution {
    // 定义一个全局HashMap保存信息，方便后续复用
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        map.put(0, 1);
        map.put(1, 1);
        return process(n);
    }
    public int process(int n) {
        if(map.containsKey(n)) return map.get(n);
        int res = 0;
        for (int i = 1; i<= n ; i++) {
            res += process(n-i)*process(i-1);
        }
        map.put(n, res);
        return res;
    }
}
