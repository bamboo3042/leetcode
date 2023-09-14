class Solution {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()
        
        s.forEach {
            if (it == '*') stack.pop()
            else stack.push(it)
        }

        return stack.joinToString("")
    }
}