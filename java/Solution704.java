class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0);
    }
    private int search(int[] nums, int target,  int offset) {
        if( nums == null
            ||
            nums.length == 0) return -1;
        int i = nums.length/2;
        if( nums[i] == target) return i + offset;
        if( nums[i] > target ) return search(Arrays.copyOfRange(nums, 0, i), target, offset);
        else return search(Arrays.copyOfRange(nums, i+1, nums.length), target, i+ offset +1);
    }
}
