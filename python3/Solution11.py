class Solution:
    def maxArea(self, height: List[int]) -> int:
        pl = 0
        pr = len(height) -1
        res = 0
        while pl < pr :
            h = min(height[pl], height[pr])
            l = pr - pl
            s = l * h
            res = s if s > res else res
            if height[pl] > height[pr]:
                pr-=1
            else:
                pl+=1
        return res
