class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if ( s.length() == 0 || s.length()==1) return s.length();
        char[] chars = s.toCharArray();
        boolean[] hash = new boolean[96];
        // length 
        for ( int length = 1;length <= chars.length ;length++) {
            // head
            boolean found = true;
            int[] has = new int[length];
            for( int head = 0; head <= chars.length- length; head++) {
                // array
                int tmp = 0;
                for (int i = head; i< head + length; i++) {
                    if (hash[chars[i]-32] == true) break;
                    hash[chars[i]-32] = true;
                    has[tmp] = chars[i]-32;
                    tmp ++;
                }
                for (int address  :has) {
                    hash[address] = false;
                }
                if (tmp == length) {
                    found = false;
                    break;
                }
            }
            if ( !found && length == chars.length) return length;
            if ( found) {
                return length -1;
            }
        }
        return -1;
    }
}

// 9ms 41.5MB
