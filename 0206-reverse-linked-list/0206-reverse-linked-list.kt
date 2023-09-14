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
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null || head.next == null) return head
        
        var temp = head!!.next
        var prev = head
        var result = head
        
        result!!.next = null
        
        while(temp != null) {
            prev = temp
            temp = temp?.next
            prev!!.next = result
            result = prev
        }
        
        return result
    }
}