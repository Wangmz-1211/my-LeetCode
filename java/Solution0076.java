class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[53], checkList = new int[52];
        int l = 0, r = s.length()+ 1, ps = 0, pf = 0;
        boolean cv = false, res = false;
        int p = 0;
        for(int i = 0; i < t.length(); i++) {
            int e = mapping(t.charAt(i));
            if(map[e] == 0) checkList[p++] = e;
            map[e]--;
        }
        while((cv = cover(map, checkList, p)) || pf < s.length() ) {
            if(cv) {
                res = true;
                if(r - l > pf - ps) {
                    r = pf;
                    l = ps;
                }
                map[mapping(s.charAt(ps++))]--;
            } else {
                map[mapping(s.charAt(pf++))]++;
            }
        }
        return res? s.substring(l, r): "";
    }
    private boolean cover(int[] map, int[] checkList, int len) {
        for(int i = 0; i < len; i++) {
            if(map[checkList[i]] < 0) return false;
        }
        return true;
    }
    private int mapping(char c) {
        if( 'a' <= c && c <= 'z') return c - 'a' + 27;
        else return c - 'A'+ 1;
    }
}
