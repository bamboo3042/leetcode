class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val arr = IntArray(k) { nums[it] }
        var p = 0
        var sum = arr.sum()
        var answer = sum.toDouble() / k
        
        for(i in k until nums.size) {
            if(p == k) p = 0
            sum = sum - arr[p] + nums[i]
            arr[p++] = nums[i]
            answer = maxOf(answer, sum.toDouble() / k)
        }
        
        return answer
    }
}