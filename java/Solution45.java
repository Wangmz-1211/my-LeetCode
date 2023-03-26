class Solution {
    public int jump(int[] nums) {
        int curPos = 0;
        int step = 0;
        int n = nums.length;
        while(curPos < n-1){
            step ++;
            int range = nums[curPos];
            curPos = findMax(nums, curPos, range);

        }
        return step;
    }
    private int findMax(int[] nums, int curPos, int range){
        int maxPos = 0, maxJump = 0;
        for(int gap = 1; gap <= range; gap++ ){
            int nextPos = curPos + gap;
            if(nextPos >= nums.length-1 ) return nextPos;
            int nextJump = nums[nextPos];
            if(gap + nextJump > maxJump){
                maxPos = nextPos;
                maxJump = nextJump + gap;
            }
        }
        return maxPos;
    }
}
