class Solution {
    fun largestAltitude(gain: IntArray): Int {
        return gain.fold(intArrayOf(0)) { acc, i -> acc + (acc.last() + i)}.max()
    }
}