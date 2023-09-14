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
    fun oddEvenList(head: ListNode?): ListNode? {
        var oddHead: ListNode? = null
        var evenHead: ListNode? = null
        var oddTail: ListNode? = null
        var evenTail: ListNode? = null
        var temp = head
        var count = 0
        
        while(temp != null) {
            count++
            if(count % 2 == 1) {
                if(oddHead == null) {
                    oddHead = temp
                    oddTail = temp
                }
                else {
                    oddTail!!.next = temp
                    oddTail = temp
                }
            }
            else {
                if(evenHead == null) {
                    evenHead = temp
                    evenTail = temp
                }
                else {
                    evenTail!!.next = temp
                    evenTail = temp
                }
            }
            temp = temp?.next
        }
        
        if(oddTail != null) oddTail.next = evenHead
        if(evenTail != null) evenTail.next = null
        
        return oddHead
    }
}