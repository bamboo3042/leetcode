class Solution {
    fun singleNumber(nums: IntArray): Int {
        val numSet = mutableSetOf<Int>()

        nums.forEach { n ->
            if(numSet.contains(n)) numSet.remove(n) else numSet.add(n)
        }

        return numSet.first()
    }
}