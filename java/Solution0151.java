class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        boolean meet = false;
        char[] chars = s.toCharArray();
        for(int i = n-1; i >= 0; i--) {
            // found a word
            if(chars[i] != ' '){
                meet = true;
                continue;
            }
            if(chars[i] == ' '){
                if(meet) {
                    meet = false;
                    // append a word
                    for(int j = i+1; j < n; j ++){
                        char c = chars[j];
                        if( c != ' ') sb.append(c);
                        if(c  == ' ' || j == n-1){
                            sb.append(' ');
                            break;
                        }
                    }
                // find the start of the word
                } else {
                    continue;
                }
            }
        }
        // append a word
        if(meet) {
            for(int i = 0; i < n; i++){
                char c = chars[i];
                if( c!= ' ') sb.append(c);
                if(c == ' ' || i == n-1){
                    sb.append(' ');
                    break;
                }
            }
        }
        return sb.toString().strip();
    }
}
