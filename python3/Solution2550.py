class Solution:
    def monkeyMove(self, n: int) -> int:
        res = pow(2, n, (int)(1e9+7))
        if res >=2 :
            return res -2;
        return res + (int)(1e9+5)
