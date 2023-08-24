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
