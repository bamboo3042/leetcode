class Solution {
    fun compress(chars: CharArray): Int {
        var str = ""
        var count = 0
        
        chars.forEach {
            if (str.isEmpty()) {
                str += it
                count = 1
            }
            else if (it != str.last()) {
                if(count != 1) str += count
                str += it
                count = 1
            }
            else count++
        }
        
        if(count != 1) str += count
        str.forEachIndexed { index, c -> chars[index] = c }
        
        return str.length
    }
}