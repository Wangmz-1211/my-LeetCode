class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for( int i = m-2; i>= 0; i--){
            List<Integer> cur = triangle.get(i);
            List<Integer> nxt = triangle.get(i+1);
            for(int j = 0; j< cur.size(); j++){
                int a = nxt.get(j), b = nxt.get(j+1);
                cur.set(j, cur.get(j)+(a > b? b: a));
            }
        }
        return triangle.get(0).get(0);
    }
}
