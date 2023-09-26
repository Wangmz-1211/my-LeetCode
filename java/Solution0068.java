class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int l = 0, r = 0;
        int totalLength = -1;
        int numberOfWords = 0;
        int numberOfLetters = 0;
        int numberOfBlankSpaces = 0;
        int numberOfBlanks = 0;
        int index = 0;
        List<String> res = new ArrayList<>();
        StringBuilder sb;
        int i;
        while(l < n){
            totalLength = -1;
            while(r < n){
                totalLength += words[r].length();
                totalLength ++;
                r++;
                if(totalLength > maxWidth) {
                    r--;
                    break;
                }
            }
            numberOfWords = r - l;
            numberOfLetters = 0;
            for(i = l; i < r ; i++){
                numberOfLetters += words[i].length();
            }
            numberOfBlankSpaces = maxWidth - numberOfLetters;
            numberOfBlanks = numberOfWords - 1;
            index = 0;
            sb = new StringBuilder();
            while(l < r){
                // append word
                sb.append(words[l]);
                // append blank
                if( r == n) {
                    if( l < n-1) sb.append(' ');
                } else for(i = 0; i < blankLength(numberOfBlankSpaces, numberOfBlanks, index); i++) {
                    sb.append(' ');
                }
                l++;
                index++;
            }
            int tmp = maxWidth - sb.length();
            for(i = 0; i < tmp; i++) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
        
    }


    private int blankLength(int blankSpaces, int blanks, int index) {
        if(index == blanks) return 0;
        int base = blankSpaces / blanks;
        int pro = blankSpaces % blanks;
        if( index < pro ) return base +1;
        return base;
    }
}
