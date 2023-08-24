class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int pl = 0, pr = length-1;
        int rmax = nums[length-1];
        while(pr > pl){
            int cur = pl + (pr-pl)/2;
            if( nums[cur] > rmax) {
                pl = cur + 1;
            } else {
                pr = cur;
            }
        }
        return nums[pr];
    }
}
