class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        int des = nums.length-1;
        int jump = nums[pos];
        if(pos == des) return true;
        while(jump --> 0){
            pos++;
            if(pos == des) return true;
            jump = nums[pos]> jump? nums[pos]: jump;
        }
        return false;
    }
}
