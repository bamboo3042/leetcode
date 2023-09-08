class Solution {
    fun compress(chars: CharArray): Int {
        var index = 0
        var count = 1

        for(i in chars.indices) {
            if(i == 0) continue

            if(chars[i] == chars[index]) count++
            else {
                if(count != 1) {
                    count.toString().forEachIndexed { i, n ->
                        chars[index+i+1] = n
                    }
                    index++
                }
                index += count.toString().length
                chars[index] = chars[i]
                count = 1
            }
        }
        
        if(count != 1) {
            count.toString().forEachIndexed { i, n ->
                chars[index+i+1] = n
            }
            index++
        }
        index += count.toString().length

        return index
    }
}