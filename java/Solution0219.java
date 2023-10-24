class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        // when k > nums.length
        if( k > nums.length){
            for(int i = 0; i < nums.length; i ++) {
                if(!set.add(nums[i])) return true;
            }
            return false;
        }        
        for(int i = 0; i < k; i++) {
            if(!set.add(nums[i])) return true;
        }
        int ps = 0, pf = k;
        while(pf < nums.length) {
            if(!set.add(nums[pf])) return true;
            set.remove(nums[ps]);
            ps++; pf++;
        }
        return false;
    }
}
