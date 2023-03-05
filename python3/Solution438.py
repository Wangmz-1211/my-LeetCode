class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        s_len = len(s)
        p_len = len(p)
        if(p_len > s_len):
            return res
        count = [0]*26
        zeros = [0]*26
        for i in range(p_len):
            count[ord(p[i])-97]+=1
            count[ord(s[i])-97]-=1
        if count == zeros:
            res.append(0)
        ps = 0
        pf = p_len
        while pf < s_len:
            count[ord(s[pf])-97]-=1
            count[ord(s[ps])-97]+=1
            pf+=1
            ps+=1
            if count == zeros:
                res.append(ps)
        return res
