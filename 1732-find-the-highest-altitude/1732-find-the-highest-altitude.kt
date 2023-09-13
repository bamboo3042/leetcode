class Solution {
    fun largestAltitude(gain: IntArray): Int {
        val result = IntArray(gain.size + 1) { 0 }
        
        for(i in gain.indices) {
            result[i+1] = result[i] + gain[i]
        }
        
        return result.max()
    }
}