class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        res = []
        start = -1
        end = -2
        l1 = len(firstList)
        l2 = len(secondList)
        p1 = 0
        p2 = 0
        while p1 < l1 and p2 < l2 :
            start = max(firstList[p1][0], secondList[p2][0])
            end = min(firstList[p1][1], secondList[p2][1])

            if(start <= end) :
                res.append([start , end])

            if(firstList[p1][1]> secondList[p2][1]):
                p2+=1
            else :
                p1+=1
        return res;
