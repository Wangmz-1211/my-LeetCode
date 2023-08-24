class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ls = s.length();
        int lp = p.length();
        if(lp > ls) return res;
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        for(char c: cp){
            count[c-'a']++;
        }
        int ps = 0, pf = 0;
        for(pf = 0; pf< lp; pf++){
            count[ cs[pf]-'a' ]--;
        }
        if(check(count)) res.add(ps);
        while(pf< ls){
            count[ cs[ps++]-'a'] ++;
            count[ cs[pf++]-'a'] --;
            if(check(count)) res.add(ps);
        }
        return res;
    }
    private boolean check(int[] a){
        for (int k=0; k<26; k++){
                if(a[k] != 0) return false;
        }
        return true;
    }
}
