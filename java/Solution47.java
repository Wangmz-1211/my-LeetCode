class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int[] shadow = new int[nums.length];
        process(res, nums, new ArrayList<Integer>(), shadow);
        return res;
    }
    private void process(List<List<Integer>> res , int[] nums, List<Integer> list, int[] shadow){
        int length = nums.length;
        int lastNum = 11;
        for(int numId=0; numId< length; numId++){
            int num = nums[numId];
            if( num != lastNum && shadow[numId] == 0){
                shadow[numId] = 1;
                List<Integer> listBackup = new ArrayList<>(list);
                listBackup.add(num);
                if(listBackup.size()==length) res.add(listBackup);
                lastNum = num;
                process(res, nums, listBackup, shadow);
                shadow[numId] = 0;
            }
        }
    }
}
