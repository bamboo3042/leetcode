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
    
    val depthVisited = BooleanArray(100) {false}
    
    fun rightSideView(root: TreeNode?): List<Int> {
        return fillList(root, 0)
    }
    
    fun fillList(root: TreeNode?, depth: Int): List<Int> {
        if(root == null) return listOf()
        
        var temp = if(!depthVisited[depth]) {
            depthVisited[depth] = true
            listOf(root.`val`)
        } else listOf()
        
        return temp +
        fillList(root.right, depth+1) +
        fillList(root.left, depth+1)
    }
}