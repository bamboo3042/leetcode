class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val aeiou = "aeiou"
        var answer = 0
        var left = 0
        var right = k-1
        var count = s.substring(left, k).count { it in aeiou }
        answer = count

        while(++right < s.length) {
            if(s[left++] in aeiou) count--
            if(s[right] in aeiou) count++
            answer = maxOf(answer, count)
        }

        return answer
    }
}