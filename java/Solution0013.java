class Solution {
    /**
    M - 1000
    D - 500
    C - 100
    L - 50
    X - 10
    V - 5
    I - 1
     */

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < chars.length; i ++){
            int value = getValue(chars[i]);
            // case like IX IV ..
            if(value > min){
                res -= getValue(chars[i-1]) * 2;
            }
            min = value;
            res += value;
        }
        return res;
        
    }

    private int getValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
