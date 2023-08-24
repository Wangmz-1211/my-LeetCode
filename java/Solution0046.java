class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] flag = new boolean[length];
        process(new ArrayList<Integer>(), flag, nums);
        return res;
    }

    private void process(List<Integer> list, boolean[] flag, int[] nums){
        if(list.size()==flag.length) {
            res.add(list);
            return;
        }
        for(int i = 0; i< flag.length; i++) {
            if(flag[i] == false){
                flag[i] = true;
                List<Integer> tmp = copy(list);
                tmp.add(nums[i]);
                process(tmp, flag, nums);
                flag[i] = false;
            }
        }
    }
    private List<Integer> copy(List<Integer> list){
        List<Integer> tmp = new ArrayList<Integer>();
        for(Integer i : list){
            tmp.add(i);
        }
        return tmp;
    }

    

}
