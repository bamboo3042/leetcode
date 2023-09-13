class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var sum = nums.sum()
        var temp = 0
        
        nums.forEachIndexed { index, i ->
            sum -= i
            if(sum == temp) return index
            temp += i
        }
        
        return -1
    }
}