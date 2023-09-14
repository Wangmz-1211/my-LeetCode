class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0 )return;
        if (m == 0) {
            for (int i=0; i< n; i++) {
                nums1[i]=  nums2[i];
            }
            return;
        }
        int[] tmp = Arrays.copyOfRange(nums1, 0, m);
        int p1 = 0;
        int p2 = 0;
        int length=  0;
        while(p1 < m && p2 < n) {
            nums1[length++] = tmp[p1] < nums2[p2] ? tmp [p1++] : nums2[p2++];
        }
        while(p1 < m) {
            nums1[length++] = tmp[p1++];
        }
        while(p2 < n) {
            nums1[length++] = nums2[p2++];
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int p = 0, p1 = 0, p2 = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] <= nums2[p2]){
                nums[p++] = nums1[p1++];
            }else {
                nums[p++] = nums2[p2++];
            }
        }
        while(p1 < m){
            nums[p++] = nums1[p1++];
        }
        while(p2< n){
            nums[p++] = nums2[p2++];
        }
        for(int i = 0; i < m+n; i++){
            nums1[i] = nums[i];
        }
    }
}
