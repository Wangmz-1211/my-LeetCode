class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) return 0;
        List<Integer> listLengths = findLength(nums);
        int res = 0;
        for( int l : listLengths){
            int k = 1;
            while(l --> 2){
                res += k++;
            }
        }
        return res;
    }
    private List<Integer> findLength(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int gap = nums[1]-nums[0];
        int pre = 0;
        for(int cur = 1; cur < nums.length; cur ++){
            if(nums[cur] - nums[cur-1] == gap) {
                continue;
            } else {
                gap = nums[cur] - nums[cur-1];
                int l = cur - pre;
                pre = cur-1;
                if( l < 3) continue;
                else res.add(l);
            }
        }
        int l = nums.length - pre;
        if (l >= 3) res.add(l);
        return res;
    }
}
