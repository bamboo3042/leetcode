class Solution {
    fun decodeString(s: String): String {
        var result = ""
        val stack = Stack<String>()

        s.forEach {
            if (it == ']') {
                var temp = ""
                while(stack.peek() != "[") temp = stack.pop() + temp
                stack.pop()
                
                var i = ""
                while (stack.isNotEmpty() && stack.peek() in "0" .. "9") i = stack.pop() + i

                var str = ""
                repeat(i.toInt()) { str += temp }
                stack.push(str)
            }
            else stack.push(it.toString())
        }

        while (stack.isNotEmpty()) result = stack.pop() + result

        return result
    }
}