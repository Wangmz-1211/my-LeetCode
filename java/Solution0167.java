class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pl = 0, pr = numbers.length-1;
        while(true){
            int tmp = numbers[pl]+numbers[pr];
            if( tmp == target) return new int[]{pl+1, pr+1};
            else if (tmp > target) pr--;
            else pl++;
        }
    }
}
