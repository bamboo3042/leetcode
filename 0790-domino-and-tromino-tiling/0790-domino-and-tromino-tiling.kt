class Solution {
    fun numTilings(n: Int): Int {
        return if(n == 1) 1
        else if(n == 2) 2
        else if(n == 3) 5
        else {
            val dp = IntArray(n+1) {0}
            val mod = 1000000007
            var count = 4
            dp[0] = 1
            dp[1] = 1
            dp[2] = 2
            dp[3] = 5
            for(i in 4 .. n) {
                dp[i] = ((dp[i-1] + dp[i-2]) % mod + count) % mod
                count = (count + dp[i-2] * 2 % mod) % mod
            }
            
            dp[n]
        }
    }
}