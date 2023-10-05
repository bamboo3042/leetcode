class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var m = 0
        var l = 1
        var r = piles.max()

        while(l <= r) {
            if(m == (l + r) / 2) break
            m = (l + r) / 2
            val t = piles.sumOf { if(it % m == 0) it / m else it / m + 1 }
            if(t <= h) r = m
            else l = m
        }

        return if(piles.sumOf { if(it % m == 0) it / m else it / m + 1 } <= h) m
        else m + 1
    }
}