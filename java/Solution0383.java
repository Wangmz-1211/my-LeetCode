class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] tmp = new int[26];
        for (byte aByte : magazine.getBytes()) {
            tmp[aByte-97]++;
        }
        for (byte aByte : ransomNote.getBytes()) {
            if(tmp[aByte -'a']==0) return false;
            else tmp[aByte -'a']--;
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        // mapping
        int[] map = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i)-'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            int key = ransomNote.charAt(i)-'a';
            if(map[key] > 0) {
                map[key] --;
            } else return false;
        }
        return true;
    }
}
