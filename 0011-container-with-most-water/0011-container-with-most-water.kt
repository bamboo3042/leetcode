class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var answer = 0
        
        while(left < right) {
            val temp = minOf(height[left], height[right]) * (right - left)
            answer = maxOf(answer, temp)
            
            if(height[left] < height[right]) left++
            else right--
        }
        
        return answer
    }
}