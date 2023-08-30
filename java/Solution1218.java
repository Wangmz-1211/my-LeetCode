import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        // dp start
        for (int num : arr) {
            if (!map.containsKey(num - difference)) {
                map.put(num, 1);
                continue;
            }
            int l = 0;
            map.put(num, l = (map.get(num - difference) + 1));
            res = Math.max(res, l);
        }
        return res;
    }
}
