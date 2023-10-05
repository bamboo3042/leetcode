class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var a = cost[0]
        var b = cost[1]
        
        for(i in 2 until cost.size) {
            val t = cost[i] + minOf(a, b)
            a = b
            b = t
        }
        
        return minOf(a, b)
    }
}