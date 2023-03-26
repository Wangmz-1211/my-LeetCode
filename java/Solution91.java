class Solution {
    public int numDecodings(String s) {
        int[] res = new int[s.length()];
        boolean[] flags = new boolean[s.length()];
        char[] chars = s.toCharArray();
        int cur = 0;
        if(chars[0] == '0') return 0;
        if(cur == 0) res[cur++]= 1;
        while(cur < chars.length){
            char c = chars[cur];
            char pre = chars[cur-1];
            int ppp;
            if(cur >=2) ppp = res[cur-2];
            else ppp = 0;
            if(pre == '0' && c == '0') return 0;
            if(c== '0' && pre >='3') return 0;
            if(pre == '1'){
                // if(flags[cur-1]) res[cur] = res[cur-1] + (res[cur-1]+1)/2;
                if(flags[cur-1]) res[cur] = res[cur-1] + ppp;
                else res[cur] = 2* res[cur-1];
                if(c == '0') res[cur] -= res[cur-1];
                flags[cur] = true;
            } else if(pre == '2'){
                if(c >= '0' && c <= '6'){
                    // if(flags[cur-1]) res[cur] = res[cur-1] + (res[cur-1]+1)/2;
                    if(flags[cur-1]) res[cur] = res[cur-1] + ppp;
                    else res[cur] = 2* res[cur-1];
                    if(c=='0') res[cur] -= res[cur-1];
                    flags[cur] = true;
                } else res[cur] = res[cur-1];
            } else {
                res[cur] = res[cur-1];
            }
            cur++;
        }
        return res[res.length-1];

    }
}
