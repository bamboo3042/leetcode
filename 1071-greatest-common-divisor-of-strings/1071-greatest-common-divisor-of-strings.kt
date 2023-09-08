class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        var answer = ""
        val min = minOf(str1.length, str2.length)

        for(i in 1 .. min) {
            val temp = str1.substring(0, i)
            if(isDivide(str1, temp) && isDivide(str2, temp)) answer = temp
        }

        return answer
    }

    private fun isDivide(str: String, dev: String): Boolean {
        var t = 0
        for(i in dev.length .. str.length step dev.length) {
            if(str.substring(t, i) != dev) return false
            t = i
        }
        return t == str.length
    }
}