class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        int des = nums.length-1;
        int jump = nums[pos];
        if(pos == des) return true;
        while(jump-- > 0){
            pos++;
            if(pos == des) return true;
            jump = nums[pos]> jump? nums[pos]: jump;
        }
        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int maxJump = 0;
        for(int i = 0; i < n - 1; i ++){
            maxJump = Math.max(--maxJump, nums[i]);
            if(maxJump < 1) return false;
        }
        return maxJump > 0;
    }
}
