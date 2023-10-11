class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var cash = 0
        var hold = -prices[0]

        for (i in 1 until prices.size) {
            cash = maxOf(cash, hold + prices[i] - fee)
            hold = maxOf(hold, cash - prices[i])
        }

        return cash
    }
}