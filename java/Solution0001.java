// shit
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] arr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i< arr.length; i++) {
            res[0] = arr[i];
            int f = Arrays.binarySearch(arr, target - arr[i]);
            if (f>=0){
                res[1] = arr[f];
                break;
            }
        } 
        boolean[] flag = {false, false};
        int i = 0;
        while( !(flag[0]&&flag[1]) ){
            if (!flag[0] && nums[i] == res[0]) {
                res[0] = i;
                flag[0] = true;
                i++;
                continue;
            }
            if (!flag[1] && nums[i] == res[1]) {
                res[1] = i;
                flag[1] = true;
            }
            i++;
        }
        return res;
    }
}

// 1ms perfect
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0 ; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {0, 0};

    }
}

// 2ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] nsort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nsort);
        int ps = 0, pf = nsort.length-1;
        int ts = 0, tf = 0, sum = 0;
        while(ps < pf) {
            if((sum = nsort[ps] + nsort[pf]) == target) {
                ts = nsort[ps]; tf= nsort[pf]; break;
            } else if ( sum < target) ps++;
            else pf--;
        }
        int[] ans = {-1, -1};
        for(int i = 0; i < nums.length; i ++) {
            if(ans[0]!= -1 && ans[1] != -1) return ans;
            if(nums[i] == ts && ans[0] == -1) {
                ans[0] = i;
                continue;
            }
            if(nums[i] == tf && ans[1] == -1) {
                ans[1] = i;
                continue;
            }
        }
        return ans;
    }
}
