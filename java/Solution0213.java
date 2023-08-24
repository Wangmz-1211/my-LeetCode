class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return nums[0]> nums[1]? nums[0]: nums[1];
        int[] sub = new int[length];
        // with head, without tail
        sub[0] = nums[0];
        sub[1] = nums[0]> nums[1]? nums[0]: nums[1];
        for(int index = 2; index< length; index++){
            int v1= nums[index] + sub[index-2];
            int v2= sub[index-1];
            sub[index] = v1> v2? v1: v2;
        }
        int max = sub[length-2];
        // with tail, without head
        sub[0] = 0;
        sub[1] = nums[1];
        for(int index = 2; index< length; index++){
            int v1= nums[index] + sub[index-2];
            int v2= sub[index-1];
            sub[index] = v1> v2? v1: v2;
        }
        return max > sub[length-1]? max: sub[length-1];
    }
}
