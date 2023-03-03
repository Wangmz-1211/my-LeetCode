class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int a = 111111;
        for (int i = 0; i< nums.length-2; i++){
            if( nums[i] == a) continue;
            a = nums[i];
            if(a > 0) return res;
            int pl = i+1;
            int pr = nums.length-1;
            int b = 111111, c= 111111;
            while(pr > pl){
                // 记录取值
                b = nums[pl];
                c = nums[pr];
                // 计算三数之和
                int sum = a + b + c;
                // System.out.println(sum);
                // 判断
                if( sum==0) {
                    res.add(commit(a, b, c));
                    while(pl< pr && nums[pl]==b) pl++;
                    continue;
                }else if( sum < 0) {
                    while(pl< pr && nums[pl]==b) pl++;
                }
                else while(pl<pr && nums[pr]==c) pr--;
            }
            b = 111111; c = 111111;
        }
        return res;
    }
    private List<Integer> commit(int a, int b, int c){
        List<Integer> res = new ArrayList<>(3);
        res.add(a);res.add(b);res.add(c);
        return res;
    }
}
