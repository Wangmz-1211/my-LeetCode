class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int pl = 0;
        int pr = chars.length -1 ;
        while (pl < pr) {
            if (!ef(chars[pl])) {
                pl ++ ;
                continue;
            }
            if (!ef(chars[pr])) {
                pr -- ;
                continue;
            } 
            if (!eq(chars[pl], chars[pr])) return false;
            pl ++ ;
            pr -- ;
        }
        return true;
    }
    // check if the char is a number or a letter
    public boolean ef(char c) {
        return 
        c >= 'a' && c <= 'z' ||
        c >= '0' && c <= '9' ||
        c >= 'A' && c <= 'Z';  
    }
    // check if the char is a number
    public boolean nm(char c) {
        return c >='0' && c <='9';
    }
    // check if two chars meet the palindrome condition
    public boolean eq(char a, char b) {
        if (nm(a)) return a == b;
        return 
        a == b || a - b == 'A' - 'a' || b - a == 'A' - 'a'; 
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n-1;
        char cl = 0, cr = 0;
        while(l < r) {
            cl = s.charAt(l);
            cr = s.charAt(r);
            if( 'A' <= cl && cl <= 'Z') cl += 32;
            if( 'A' <= cr && cr <= 'Z') cr += 32;
            if( !('a' <= cl && cl <= 'z' || '0' <= cl && cl <= '9')) {
                l++;
                continue;
            }
            if( !('a' <= cr && cr <= 'z' || '0' <= cr && cr <= '9')) {
                r--;
                continue;
            }
            if( cl != cr) return false;
            l++;
            r--;
        }
        return true;
    }
}
