class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        boolean flag = true;
        for(int i = 0; i < n - m + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                flag = true;
                for(int j = 1; j < m; j ++){
                    if( haystack.charAt(i+j) != needle.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }
        }
        return -1; 
    }
}
