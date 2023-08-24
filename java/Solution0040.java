class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        process(res, candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void process(List<List<Integer>> res, int[] candidates, int target, int startId, List<Integer> pre, int sum){
        int length = candidates.length;
        int lastNum = 0;
        for(int candidatesId=startId; candidatesId< length; candidatesId++){
            int num = candidates[candidatesId];
            if( num == lastNum ) continue;
            lastNum = num;
            if( num+ sum > target) return;
            List<Integer> cur = new ArrayList<>(pre);
            cur.add(num);
            if( num + sum == target) {
                res.add(cur);
                return;
            }
            process(res, candidates, target, candidatesId+1, cur, sum+num);
        }
    }
}
