class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            if(map.containsKey(word)) 
                map.put(word, map.get(word)+1);
            else map.put(word, 1);
        }
        // some base parameters
        int n = s.length(), m = words[0].length(), k = words.length;
        int targetLen = m * k;
        // pointers
        int l = 0, r = 0;
        // tmp
        String substr = null;
        for(int i = 0; i < m; i++){
            // initialize the map
            while(l < r){
                substr = s.substring(l, l+m);
                map.put(substr, map.get(substr)+1);
                l+= m;
            }
            // initialize the start
            l = i;
            r = i;
            // slide window
            while(r <= n - m) {
                // next substr
                substr = s.substring(r, r+m);
                // a substr not in words
                if(!map.containsKey(substr)) {
                    while(l < r){
                        substr = s.substring(l, l+m);
                        map.put(substr, map.get(substr)+1);
                        l+= m;
                    }
                    r += m;
                    l = r;
                    continue;
                // a substr in words
                } else {
                    // duplicate word
                    if(map.get(substr) == 0) {
                        substr = s.substring(l, l+m);
                        map.put(substr, map.get(substr)+1);
                        l += m;
                    // hit a word
                    } else {
                        map.put(substr, map.get(substr)-1);
                        r += m;
                    }
                }
                // check got an answer or not
                if(r - l == targetLen) {
                    ans.add(l);
                    substr = s.substring(l, l+m);
                    map.put(substr, map.get(substr)+1);
                    l += m;
                }
            }
        }
        return ans;
    }
}
