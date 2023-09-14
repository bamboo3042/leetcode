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
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val l1 = getLeaf(root1)
        val l2 = getLeaf(root2)
        
        return l1 == l2
    }
    
    fun getLeaf(root: TreeNode?): List<Int> {
        return if(root == null) listOf()
        else if(root.left == root.right) listOf(root.`val`)
        else getLeaf(root.left) + getLeaf(root.right)
    }
}