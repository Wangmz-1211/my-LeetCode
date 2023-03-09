class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        process(res, new ArrayList<Integer>(), 0, candidates, target, 0, length);
        return res;
    }
    private void process(List<List<Integer>> res,List<Integer> list, int sum,  int[] candidates, int target, int startId, int length){
        for(int candidatesId = startId; candidatesId< length; candidatesId++){
            int num = candidates[candidatesId];
            if(sum + num > target) {
                return;
            }
            List<Integer> backup = new ArrayList<>(list);
            backup.add(num);
            if(sum + num == target) {
                res.add(backup);
                return;
            }
            process(res, backup, sum+num, candidates, target, candidatesId, length);
        }
    }
}
