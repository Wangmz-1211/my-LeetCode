class Solution {
    public String alphabetBoardPath(String target) {
        char[] chars = target.toCharArray();
        int x = 0, y = 0, tx = 0, ty = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char c : chars){
            // get target char position
            tx = (c- 'a')% 5;
            ty = (c -'a')/ 5;
            while(y > ty) {
                y--;
                sb.append('U');
            }
            while(x > tx) {
                x--;
                sb.append('L');
            }
            while(y < ty) {
                y++;
                sb.append('D');
            }
            while(x < tx) {
                x++;
                sb.append('R');
            }
            sb.append('!');
        }
        return sb.toString();

    }
}
