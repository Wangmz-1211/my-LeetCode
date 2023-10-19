class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        boolean[] shadow = new boolean[26];
        HashSet<String> set = new HashSet<>();
        String[] map = new String[26];
        if(pattern.length() != strings.length) return false;
        for(int i = 0; i < strings.length; i++) {
            int key = pattern.charAt(i) - 'a';
            if( !shadow[key] && !set.contains(strings[i])) {
                shadow[key] = true;
                set.add(strings[i]);
                map[key] = strings[i];
            } else {
                if(map[key] == null || strings[i] == null) return false;
                if(!map[key].equals(strings[i])) return false;
            }
        }
        return true;
    }
}
