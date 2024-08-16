class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val sortedArray = intervals.sortedWith(compareBy({ -it[1] }))

        var start = Int.MAX_VALUE
        var end = Int.MAX_VALUE
        var answer = 0

        sortedArray.forEachIndexed { index, (s, e) ->
            if (index == 0) {
                start = s
                end = e
                return@forEachIndexed
            }
            
            if (e <= start) {
                start = s
                end = e
            }
            else if (end == e) {
                start = maxOf(start, s)
                answer++
            }
            else if (s > start){
                start = s
                end = e
                answer++
            }
            else answer++
        }

        return answer
    }
}