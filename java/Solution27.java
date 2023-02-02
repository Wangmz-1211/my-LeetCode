class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 ) return 0;
        int ps = 0;
        int pf = 0;
        while( pf < nums.length ){
            if( nums[pf] != val ) {
                nums[ps++] = nums[pf];
            }
            pf ++;
        }
        return ps;
    }
}
