class Solution {
    public int fillCups(int[] amount) {
        if (amount[0] > amount[1] + amount[2]) return amount[0];
        if (amount[2] > amount[0] + amount[1]) return amount[2];
        if (amount[1] > amount[2] + amount[0]) return amount[1];
        return (amount[0]+amount[1]+amount[2]+1)/2;
    }
}
