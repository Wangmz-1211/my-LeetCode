class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), 0);
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(List<List<Integer>> res,int[] nums, List<Integer> subset, int start){
        int lastNum = 11;
        int length = nums.length;
        for(int index= start ; index < length ; index ++){
            int num = nums[index];
            if( num!=11 && num!=lastNum ){
                lastNum = num;
                nums[index] = 11;
                // dive in
                List<Integer> tmp = new ArrayList<>(subset);
                tmp.add(num);
                res.add(tmp);
                dfs(res, nums, tmp, index);
                // dive out
                nums[index] = num;
            }
        }
    }
}
