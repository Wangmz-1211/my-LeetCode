class Solution {
    public void reverseString(char[] s) {
        char tmp ;
        int pl = 0, pr = s.length-1;
        while(pl < pr){
            tmp = s[pl];
            s[pl++] = s[pr];
            s[pr--] = tmp;
        }
        
    }
}
