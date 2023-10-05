class Solution {
    fun rob(nums: IntArray): Int {
        val dp = Array(nums.size) { IntArray(2) {0} }
        dp[0][0] = 0
        dp[0][1] = nums[0]

        for(i in 1 until nums.size) {
            dp[i][0] = dp[i-1].max()
            dp[i][1] = maxOf(dp[i-1].max(), dp[i-1][0] + nums[i])
        }

        return dp.last().max()
    }
}