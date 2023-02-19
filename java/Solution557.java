class Solution {
    public String reverseWords(String s) {
        int cur = 0;
        int ps = 0, pf = 0;
        char tmp;
        char[] chars = s.toCharArray();
        while(cur< chars.length) {
            if( chars[cur] == ' '){
                pf = cur -1;
                while(ps < pf){
                    tmp = chars[ps];
                    chars[ps++] = chars[pf];
                    chars[pf--] = tmp;
                }
                ps = cur +1;
            }
            cur++;
        }
        pf = cur-1;
        while(ps < pf){
            tmp = chars[ps];
            chars[ps++] = chars[pf];
            chars[pf--] = tmp;
        }
        return new String(chars);
    }
}
