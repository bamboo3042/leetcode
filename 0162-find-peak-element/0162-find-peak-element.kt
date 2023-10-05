class Solution {
    fun findPeakElement(nums: IntArray): Int {
        return find(nums, 0, nums.lastIndex) 
    }

    fun find(nums: IntArray, s: Int, e: Int): Int {
        if (s > e) return -1
        val m = (s + e) / 2
        return if ((m == 0 || nums[m-1] < nums[m]) && (m == nums.lastIndex || nums[m+1] < nums[m])) m
        else maxOf(find(nums, s, m-1), find(nums, m+1, e))
    }
}