class Solution {
    public List<String> letterCombinations(String digits) {
        char[] digitsChar = digits.toCharArray();
        int length = digitsChar.length;
        List<String> res = new ArrayList<>();
        if(length == 0) return res;
        char[] tmp = new char[length];
        process(res, digitsChar, 0, tmp);
        return res;
    }
    private void process(List<String> res, char[] digits, int cur, char[] tmp){
        char digit = digits[cur];
        int size = (digit == '7' || digit == '9') ? 4: 3;
        for(char offset = 0; offset< size; offset++){
            char letter = getChar(digit, offset);
            tmp[cur] = letter;
            if(cur == tmp.length-1){
                res.add(new String(tmp));
            } else process(res, digits, cur+1, tmp);
        }

    }
    private static final char[][] table = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    private char getChar(char digit, char offset){
        return this.table[digit - '2'][offset];
    }

}
