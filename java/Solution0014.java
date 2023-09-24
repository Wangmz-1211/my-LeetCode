class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(String s: strs) {
            minLen = Math.min(minLen, s.length());
        }
        StringBuffer sb = new StringBuffer();
        for(int p = 0; p < minLen; p++){
            char c = strs[0].charAt(p);
            for(String s: strs) {
                if(s.charAt(p) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
