class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if( n > m ) return false;
        if( n == 0 || m == 0 ) return true;
        int ps = 0, pt = 0;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        for(pt = 0; pt < m; pt++){
            if( cs[ps] == ct[pt]) ps++;
            if( ps == n ) return true;
        }
        return false;
        
    }
}

// follow up
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if( n > m ) return false;
        if( n == 0 || m == 0 ) return true;
        int[][] map = new int[m+1][26];
        int x = 0;
        int y = 0;
        int p = 0;
        // enumerating t
        for(x = 0; x <=m ; x++) for(y = 0;y < 26; y ++) map[x][y] = -1;
        for(x = 0; x < m; x++) {
          y = t.charAt(x) - 'a';
          for(p = x-1; p >= -1 ; p--){
            if(map[p+1][y] == -1) map[p+1][y] = x+1;
            else break;
          }
        }
        //for(int[] o: map) System.out.println(Arrays.toString(o));
        p = 0;
        x = 0;
        while(p < n){
          y = s.charAt(p) - 'a';
          x = map[x][y];
          if(x == -1) return false;
          else p++;
        }
        return p==n;
    }
}
