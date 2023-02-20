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

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        char[] chars = s.toCharArray();
        boolean[] map = new boolean[128];
        int ps=0, pf=1, max = 1;
        map[chars[ps]] = true;
        while(pf< chars.length){
            if(map[chars[pf]]==false){
                map[chars[pf]] = true;
                pf++;
            } else {
                max = max > pf-ps? max: pf-ps;
                while(chars[ps]!=chars[pf]) {
                    map[chars[ps++]]=false;
                }
                ps++;
                map[chars[pf]] = true;
                pf++;
            }
        }
        return max > pf-ps?max: pf-ps;
    }
}

// 1ms 41.7MB
