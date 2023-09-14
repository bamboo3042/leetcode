class Solution {
    fun predictPartyVictory(senate: String): String {
        val r = ArrayDeque<Int>()
        val d = ArrayDeque<Int>()
        var t = senate.length
        
        senate.forEachIndexed { index, c -> if (c == 'R') r.addLast(index) else d.addLast(index) }
        
        while(r.isNotEmpty() && d.isNotEmpty()) {
            val rt = r.removeFirst()
            val dt = d.removeFirst()
            if (rt < dt) r.addLast(t++)
            else d.addLast(t++)
        }

        return if (r.isNotEmpty()) "Radiant" else "Dire"
    }
}