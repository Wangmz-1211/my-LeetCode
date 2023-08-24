class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int rmax = nums[length-1];
        int pl = 0, pr = length-1;
        if(target > rmax) while(pr - pl> 1){
                int cur = pl + (pr-pl+1)/2;
                if(nums[cur] < rmax || nums[cur]> target) pr = cur;
                else pl = cur; 
            } else while(pr - pl> 1){
            int cur = pl + (pr-pl+1)/2;
            if(nums[cur]> rmax || nums[cur]< target) pl = cur;
            else pr = cur;
        }
        return nums[pl] ==  target? pl: nums[pr]==target? pr: -1;
    }
}
