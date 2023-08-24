class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int pl = 0, pr = length-1;
        while(pr> pl){
            int cur = (pr+ pl)/2;
            if( nums[cur]< nums[cur+1]) pl = cur+1;
            else pr = cur;
        }
        return pr;
    }
}
