class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        process(new ArrayList<Integer>(),n, k, 0);
        return res;
    }
    private void process(List<Integer> list,int n, int k, int threshold){
        if(list.size() == k) {
            res.add(copy(list));
            return;
        }
        for(int i=threshold; i< n; i++){
                list.add(i+1);
                process(list, n, k, i+1);
                list.remove(list.size()-1);
        }
    }
    private List<Integer> copy(List<Integer> list) {
        List<Integer> tmp = new ArrayList<>();
        for(Integer i: list) tmp.add(i);
        return tmp;
    }
}
