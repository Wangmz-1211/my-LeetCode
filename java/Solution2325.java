class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char[] keys = key.toCharArray();
        char[] messages = message.toCharArray();
        char v = 'a';
        for( char k : keys) {
            if( k == ' ') continue;
            if( map[k-'a'] == 0) map[k-'a'] = v++;
            if( v > 'z') break;
        }
        for( int i=0; i< messages.length; i++) {
            if (messages[i] == ' ') continue;
            messages[i] = map[messages[i]-'a'];
        }
        return new String(messages);
    }
}
