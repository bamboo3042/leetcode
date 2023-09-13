class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var answer = 0
        var temp = 0
        
        gain.forEach {
            temp += it
            answer = maxOf(answer, temp)
        }
        
        return answer
    }
}