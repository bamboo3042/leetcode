class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = nums.fold(intArrayOf()) { acc: IntArray, i -> if (acc.isEmpty()) intArrayOf(i) else acc + i*acc.last() }
        val right = nums.foldRight(intArrayOf()) { i, acc: IntArray -> if (acc.isEmpty()) intArrayOf(i) else acc + i*acc.last() }.reversedArray()
        return IntArray(nums.size) {
            val l = if (it > 0) left[it-1] else 1
            val r = if (it < nums.size-1) right[it+1] else 1
            l * r
        }
    }
}