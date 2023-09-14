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
    val arr = mutableListOf<Int>()
    
    fun maxLevelSum(root: TreeNode?): Int {
        getLevelSum(root, 0)
        
         var temp = 0
        arr.forEachIndexed { index, i -> if (i > arr[temp]) temp = index }
        return temp+1
   }
    
    fun getLevelSum(root: TreeNode?, level: Int) {
        if(root == null) return
        
        if(arr.size <= level) arr.add(root.`val`) else arr[level] += root.`val`
        
        getLevelSum(root.left, level+1)
        getLevelSum(root.right, level+1)
    }
}