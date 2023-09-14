/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        return getPathSum(root, targetSum, listOf())
    }
    
    fun getPathSum(root: TreeNode?, targetSum: Int, arr: List<Int>): Int {
        if(root == null) return 0
        else {
            var sum = 0L
            val nextArr = listOf(root.`val`) + arr
            var count = 0
            nextArr.forEach {
                sum += it.toLong()
                if(sum == targetSum.toLong()) count++
            }
            
            return getPathSum(root.left, targetSum, nextArr) + getPathSum(root.right, targetSum, nextArr) + count
        }
    }
}