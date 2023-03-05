class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        nums_len = len(nums)
        pl = 0
        pr = 1
        tmp = nums[0]
        if tmp >= target:
            return 1
        res = nums_len
        while pr < nums_len:
            tmp += nums[pr]
            pr+=1
            while tmp - nums[pl] >= target:
                tmp -= nums[pl]
                pl += 1
            if tmp >= target:
                res = res if res < pr - pl else pr - pl
        return res if tmp >= target else 0
