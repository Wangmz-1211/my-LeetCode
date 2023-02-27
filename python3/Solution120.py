class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        for i in range(n-2, -1, -1):
            for j in range(0, i+1):
                a = triangle[i+1][j]
                b = triangle[i+1][j+1]
                triangle[i][j] += a if a<  b else b
        return triangle[0][0]
