class Solution {
    List<String> res = new ArrayList<>();
    char offset = 'a' - 'A';
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        int[] letterPos = new int[s.length()];
        int cur = 0;
        for(int i = 0; i< chars.length; i++){
            char c = chars[i];
            if( c>='a' && c<='z'){
                letterPos[cur++] = i;
            }
            if( c>='A' && c<='Z'){
                letterPos[cur++] = i;
                chars[i] += offset;
            }
        }
        res.add(new String(chars));
        process(chars, letterPos, 0, cur);
        return res;
    }
    private void process(char[] chars,int[] letterPos, int cur, int fin){
        for(int i=cur; i< fin; i++){
            chars[ letterPos[i] ] -= offset;
            res.add(new String(chars));
            process(chars, letterPos, i+1, fin);
            chars[ letterPos[i] ] += offset;
        }
    }
}
