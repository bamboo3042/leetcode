/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var c = 0
        var temp = head
        do {
            c++
            temp = temp?.next
        } while(temp != null)
        
        temp = head
        
        repeat(c/2) { temp = temp?.next }
        
        return temp
    }
}