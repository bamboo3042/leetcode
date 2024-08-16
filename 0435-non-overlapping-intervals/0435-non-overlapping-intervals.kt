class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val sortedArray = intervals.sortedWith(compareBy({ -it[1] }))

        var start = Int.MAX_VALUE
        var answer = 0

        sortedArray.forEachIndexed { index, (s, e) ->
            if (index == 0) {
                start = s
                return@forEachIndexed
            }

            if (e <= start) {
                start = s
            }
            else {
                start = maxOf(start, s)
                answer++
            }
        }

        return answer
    }
}