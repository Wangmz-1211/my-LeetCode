class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        char[] chars = s1.toCharArray();
        int length = chars.length;
        int[] map = new int[26];
        for (char c: chars){
            map[c-'a']++;
        }
        chars = s2.toCharArray();
        int ps= 0, pf = length-1;
        for(int i= ps; i<= pf; i++){
            map[chars[i]-'a']--;
        }
        while(pf< chars.length-1){
            if( check(map) ) return true;
            else {
                map[chars[ps++]-'a']++;
                map[chars[++pf]-'a']--;
            }
        }
        return check(map);
    }
    private boolean check(int[] map){
        for (int i= 0; i< 26; i++){
            if(map[i]!=0) return false;
        }
        return true;
    }
}
