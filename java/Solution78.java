class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums){
            int size = res.size();
            for(int j = 0; j< size ;j++){
                List<Integer> subset= res.get(j);
                List<Integer> view = new ArrayList<>(subset);
                view.add(0, i);
                res.add(view);
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            res.add(tmp);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}
