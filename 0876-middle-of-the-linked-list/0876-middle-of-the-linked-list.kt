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
        val list = mutableListOf<ListNode?>()
        var temp = head
        while(temp != null) {
            list.add(temp)
            temp = temp.next
        }
        return list[list.size/2]
    }
}