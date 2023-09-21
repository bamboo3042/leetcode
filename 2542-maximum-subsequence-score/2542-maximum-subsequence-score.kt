class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        val nums = Array(n) { nums1[it] to nums2[it] }

        nums.sortWith(compareByDescending { it.second })

        val pq = PriorityQueue<Int>()
        var res = 0L
        var sum = 0L

        for (i in 0 until n) {
            pq.offer(nums[i].first)
            sum += nums[i].first.toLong()

            if (pq.size > k) sum -= pq.poll()
            if (pq.size == k) res = maxOf(res, sum * nums[i].second.toLong())
        }

        return res
    }
}
