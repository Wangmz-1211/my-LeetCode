class Solution {
    public int removeDuplicates(int[] nums) {
        int ps = 0, pf = 1;
        int n = nums.length;
        int times = 1;
        if(n <= 2) return n;
        while(pf < n){
            // A number appears 2 times,
            // if meet the same number one more time, skip it.
            if(nums[pf] == nums[ps] && times >= 2) {
                pf ++;
                continue;
            }
            // Meet a number the second time
            if(nums[pf] == nums[ps]) times++;
            // Meet a new number
            else times = 1;
            // Write the new number into the array
            nums[++ps] = nums[pf++];
        }
        return ps+1; 
    }
}
