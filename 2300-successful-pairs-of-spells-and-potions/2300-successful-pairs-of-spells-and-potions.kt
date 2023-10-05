class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        println(potions.joinToString(" "))
        return spells.map {
            var l = 0
            var r = potions.size
            var m = 0
            while (l < r) {
                m = (l + r) / 2
                if ((potions[m].toLong() * it) >= success) r = m
                else l = m+1
            }
            if ((potions[m].toLong() * it) >= success) potions.size - m
            else if(m < potions.lastIndex && (potions[m+1].toLong() * it) >= success) potions.size - m - 1
            else 0
        }.toIntArray()
    }
}