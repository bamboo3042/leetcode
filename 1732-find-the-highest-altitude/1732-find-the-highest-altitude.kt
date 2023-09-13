class Solution {
    fun largestAltitude(gain: IntArray): Int {
        return gain.fold(mutableListOf(0)) { acc, i -> acc.apply { this.add(this.last() + i) }}.max()
    }
}