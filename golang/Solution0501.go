/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findMode(root *TreeNode) []int {
    var base, maxCount, count int
    var answer []int

    var dfs func(*TreeNode)
    dfs = func(node *TreeNode) {
        if node == nil {
            return
        }
        dfs(node.Left)
        val := node.Val
        if val == base {
            count++
        } else {
            count = 1
            base = val
        }
        if count == maxCount {
            answer = append(answer, val)
        }
        if count > maxCount {
            answer = []int{base}
            maxCount = count
        }
        dfs(node.Right)
    }
    dfs(root)
    return answer
}
