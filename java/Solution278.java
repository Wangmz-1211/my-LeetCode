/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // public int firstBadVersion(int n) {
    //     return firstBadVersion(n/2, n/4);
    // }
    // public int firstBadVersion(int n , int gap) {
    //     if(isBadVersion(n)){
    //         if(!isBadVersion(n-1)) return n;
    //         else {
    //             return firstBadVersion(n-gap, gap/2<1? 1:gap/2);
    //         }
    //     } else {
    //         return firstBadVersion(n+gap, gap/2<1? 1:gap/2);
    //     }
    // }
    public int firstBadVersion(int n){
        int front =  1;
        while(front < n) {
            int tmp = front +  (n - front)/2;
            if(isBadVersion(tmp)) n = tmp;
            else front = tmp+1;
        }
        return front;
    }
}
