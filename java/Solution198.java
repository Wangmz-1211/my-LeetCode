class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] sub = new int[length];
        if(length ==1) return nums[0];
        sub[0] = nums[0];
        sub[1] = nums[0]>nums[1]? nums[0]: nums[1];
        for(int i= 2 ; i< length; i++){
            int v1 = nums[i] + sub[i-2];
            int v2 = sub[i-1];
            sub[i] = v1 > v2 ? v1: v2; 
        }
        return sub[length-1];
    }
}
