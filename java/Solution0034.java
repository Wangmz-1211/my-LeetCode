class Solution {
    public int[] searchRange(int[] nums, int target){
        int length = nums.length;
        int[] res = new int[] {-1, -1};
        // case: length 0
        if( length == 0) return res;

        int pl = 0, pr = length-1;
        while(pr-pl> 1){
            int cur = pl+ (pr-pl)/2;
            if(nums[cur] < target) pl = cur;
            else pr = cur;
        }
        res[0] = nums[pl]== target? pl: nums[pr]==target? pr: -1;
        if(res[0]==-1) return res;
        pl = res[0];
        pr = length-1;
        while(pr-pl>1){
            int cur = pl+(pr-pl)/2;
            if(nums[cur] > target) pr = cur;
            else pl = cur;
        } 
        res[1] = nums[pr]== target? pr: pl;
        return res;
    }
}
