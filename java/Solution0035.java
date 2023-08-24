class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, n = nums.length;
        while(n>l){
            int a = l+ (n-l)/2;
            if( nums[a] >= target ) n = a;
            else l = a+1;
        }
        return l;
    }
}
