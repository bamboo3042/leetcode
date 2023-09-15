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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if(root != null) {
            if(key < root.`val`) root.left = deleteNode(root.left, key)
            else if(key > root.`val`) root.right = deleteNode(root.right, key)
            else {
                if(root.left == null && root.right == null) return null
                else if(root.left == null || root.right == null) return root.left ?: root.right
                
                var temp = root.left
                while(temp.right != null) temp = temp.right
                root.`val` = temp.`val`
                root.left = deleteNode(root.left, temp.`val`)
            }
        }
        return root
    }
}