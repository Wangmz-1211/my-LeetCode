class Solution {
    public int[] sortedSquares(int[] nums) {
        int min = findMin(nums);
        if( min == nums.length) min--;
        int[] res = new int[nums.length];
        res[0] = nums[min]*nums[min];
        int pl = min-1;
        int pr = min+1;
        min = 1;
        while(pl >= 0 && pr < res.length ){
            if( nums[pl] + nums[pr] >= 0 ) res[min++] = nums[pl]*nums[pl--];
            else res[min++] = nums[pr]*nums[pr++]; 
        }
        while(pl >= 0) res[min++] = nums[pl]*nums[pl--];
        while(pr < nums.length) res[min++] = nums[pr]*nums[pr++];
        return res;
    }
    private int findMin(int[] nums){
        if(nums[0] >= 0) return 0;
        if(nums[nums.length-1]<=0) return nums.length-1;
        int l = 0,r=nums.length-1;
        while(l< r) {
            int a = l+ (r-l)/2;
            if( nums[a] == 0 ) return a;
            if( nums[a] > 0) r = a;
            else l = a +1;
        }
        if( nums[l] + nums[l-1]>0)return l-1; 
        return l;
    }
}
