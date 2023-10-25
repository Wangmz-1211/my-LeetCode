class Solution {
    class IntegerWrapper {
        int value = 0;
        List<IntegerWrapper> combineList = new ArrayList<>();
        
        public IntegerWrapper( int v) {
            this.value = v;
        }

        /**
         * Once a IntegerWrapper instance was set to a value,
         * other instance which was combined to it will update
         * by recursively broadcast.
         */
        public void set( int v ) {
            if(this.value == v) return;
            this.value = v;
            for(IntegerWrapper combine: this.combineList) {
                combine.set(v);
            }
        }

        /**
         * Each instance should exec this method during a combination
         * operation.
         */
        public void combine(IntegerWrapper neighbour) {
            this.combineList.add(neighbour);
        }

        public int get() {
            return this.value;
        }

        public String toString() {
            return " " + this.value;
        }
    }
    public int longestConsecutive(int[] nums) {
        if( nums.length == 0) return 0;
        int ans = 0;
        Map<Integer, IntegerWrapper> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) continue;
            else {
                IntegerWrapper s = null, b = null;
                if( map.containsKey(num-1)) s = map.get(num-1);
                if( map.containsKey(num+1)) b = map.get(num+1);
                if( s == null && b == null) {
                    IntegerWrapper c = new IntegerWrapper(1);
                    map.put(num, c);
                    ans = Math.max(ans, 1);
                    continue;
                }
                if( s != null && b != null) {
                    int len = s.get() + b.get() + 1;
                    map.put(num, s); // or b
                    s.combine(b);
                    b.combine(s); 
                    s.set(len);
                    ans = Math.max(ans, len);
                    continue;
                }
                if( s == null && b != null) {
                    map.put(num, b);
                    b.set(b.get()+1);
                    ans = Math.max(ans, b.get());
                    continue;
                } 
                if( s != null && b == null ) {
                    map.put(num, s);
                    s.set(s.get() + 1);
                    ans = Math.max(ans, s.get());
                    continue;
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int ans = 0, cur = 0;
        Integer[] entries = set.toArray(new Integer[0]);
        for(Integer entry: entries) {
            if( !set.contains(entry) ) continue;
            cur = 1;
            Integer p = entry - 1;
            while( set.contains(p)) {
                cur ++;
                set.remove(p);
                p--;
            }
            p = entry + 1;
            while( set.contains(p)) {
                cur ++;
                set.remove(p);
                p++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
