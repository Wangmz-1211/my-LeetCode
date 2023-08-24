class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int ps = 0; 
        int pf = 0;
        while (pf < nums.length) {
            if ( nums[pf] != nums[ps] ) {
                nums[++ps] = nums[pf];
            }
            pf ++;
        }
        return ++ps;
    }
}
