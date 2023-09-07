class Solution {
    fun numberOfSteps(num: Int): Int {
        var temp = num
        var count = 0
        
        while(temp > 0) {
            if(temp % 2 == 0) temp /= 2
            else temp -= 1
            count++
        }

        return count
    }
}