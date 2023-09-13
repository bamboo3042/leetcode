class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val list1 = nums1.toHashSet()
        val list2 = nums2.toHashSet()
        return listOf((list1 - list2).toList(), (list2 - list1).toList())
    }
}