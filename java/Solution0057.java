class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int[][] is = new int[intervals.length+1][2];
        is[0] = newInterval;
        for(int i = 0 ; i < intervals.length; i++) {
            is[i+1] = intervals[i];
        }
        Arrays.sort(is, (int[] a, int[] b) -> {
            return a[0] -b[0];
        });
        Deque<int[]> ans = new ArrayDeque<>();
        ans.offerLast(is[0]);
        for( int[] interval :  is) {
            int[] last = ans.peekLast();
            if(isOverlap(last, interval)) {
                ans.removeLast();
                ans.offerLast(merge(last, interval));
            } else {
                ans.offerLast(interval);
            }
        }
        return ans.toArray(new int[1][]);
    }

    private boolean isOverlap(int[] a, int[] b ) {
        return  ( a[0] >= b[0] && a[0] <= b[1]) ||
                ( a[1] >= b[0] && a[1] <= b[1]) ||
                ( b[0] >= a[0] && b[1] <= a[1]) ||
                ( b[1] >= a[0] && b[1] <= a[1]);
    }

    private int[] merge(int[] a, int[] b) {
        return new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}
