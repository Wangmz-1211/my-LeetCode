class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap< String, List<String>> map = new HashMap<>();
        for(String str: strs) {
           String s = reformat(str); 
           if( map.containsKey(s) ) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
                ans.add(list);
            }
        }
        return ans;
        
    }

    /**
     * Reformat the string constructed by lower case latters only with
     * random order to the ASCII order. 
     */
    private String reformat(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
