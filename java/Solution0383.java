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
