class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val group = arr.groupBy { it }
        return group.keys.size == group.values.map { it.size }.toHashSet().size
    }
}