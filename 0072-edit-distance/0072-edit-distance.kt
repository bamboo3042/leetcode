class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
        for (i in 1 .. word1.length) dp[i][0] = i
        for (j in 1 .. word2.length) dp[0][j] = j

        for (i in 1 .. word1.length) {
            for (j in 1 .. word2.length) {
                if (word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1]
                else dp[i][j] = minOf(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
            }
        }
        return dp.last().last()
    }
}