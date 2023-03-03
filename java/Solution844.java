class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int ps = sc.length-1;
        int pt = tc.length-1;
        while(ps >= 0 || pt >= 0){
            while(ps >=0 && get(sc, ps) == '#'){
                int count = 1;
                ps--;
                while(count>0){
                    if(get(sc, ps)== '#') {
                        ps--; count++;
                    } else {
                        ps--; count--;
                    }
                }
            }
            while(pt>=0 && get(tc, pt) == '#'){
                int count = 1;
                pt--;
                while(count>0){
                    if(get(tc, pt)== '#') {
                        pt--; count++;
                    } else {
                        pt--; count--;
                    }
                }
            }
            if(get(tc, pt) == get(sc, ps)) {
                ps--;pt--;
            } else return false;
        }
        return ps<=0 && pt<=0;
    }
    private char get(char[] chars, int index){
        int length = chars.length;
        if(index >= length || index < 0) return '0';
        else return chars[index];
    }
}
