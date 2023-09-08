class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var left = Int.MAX_VALUE
        var mid = Int.MAX_VALUE

        nums.forEach {
            if (it > mid) return true

            if (it > left && it < mid) mid = it
            else if (it < left) left = it
        }

        return false
    }
}