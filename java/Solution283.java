class Solution {
    public void moveZeroes(int[] nums) {
        int ps = 0;
        int pf = 0;
        while(pf < nums.length){
            if( nums[pf]!=0) nums[ps++]=nums[pf++];
            else pf++;
        }
        while(ps<nums.length) nums[ps++] = 0;
    }
}
