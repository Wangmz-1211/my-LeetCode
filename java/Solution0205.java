class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[128];
        boolean[] shadowC = new boolean[128];
        boolean[] shadowT = new boolean[128];
        char cs = 0, ct = 0;
        for( int i = 0 ; i < s.length(); i ++) {
            cs = s.charAt(i);
            ct = t.charAt(i);
            if( !shadowC[cs] && !shadowT[ct]) {
                shadowC[cs] = true; shadowT[ct] = true;
                map[cs] = ct;
            }else if( ct != map[cs]) return false;
        }
        return true;
    }
}
