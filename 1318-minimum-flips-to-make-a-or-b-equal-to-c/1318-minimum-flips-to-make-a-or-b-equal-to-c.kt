class Solution {
fun minFlips(a: Int, b: Int, c: Int): Int {
    var answer = 0

    repeat(32) {
        val bit = 1 shl it
        val ab = a and bit
        val bb = b and bit
        val cb = c and bit

        if (cb == 0) {
            if (ab != 0) answer++
            if (bb != 0) answer++
        }
        else {
            if (ab == 0 && bb == 0) answer++
        }
    }

    return answer
}
}