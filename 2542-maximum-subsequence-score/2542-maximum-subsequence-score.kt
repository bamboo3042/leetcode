class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        val nums = Array(n) { Num(nums1[it], nums2[it]) }

        nums.sortWith(compareByDescending { it.num2 })

        val pq = PriorityQueue<Int>()
        var res = 0L
        var sum = 0L

        for (i in 0 until n) {
            pq.offer(nums[i].num1)
            sum += nums[i].num1.toLong()

            if (pq.size > k) sum -= pq.poll()
            if (pq.size == k) res = maxOf(res, sum * nums[i].num2.toLong())
        }

        return res
    }

    inner class Num(val num1: Int, val num2: Int)
}
