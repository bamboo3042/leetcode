class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()
        nums.forEach {
            if (heap.size < k) heap.add(it)
            else if (it > heap.peek()) {
                heap.poll()
                heap.add(it)
            }
        }
        
        return heap.peek()
    }
}