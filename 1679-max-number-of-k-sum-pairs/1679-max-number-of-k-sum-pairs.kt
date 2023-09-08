class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var answer = 0
        var left = 0
        var right = nums.size - 1
        nums.sort()
        
        while(left < right) {
            val sum = nums[left] + nums[right]
            if(sum > k) right--
            else if(sum < k) left++
            else {
                answer++
                left++
                right--
            }
        }

        
        return answer
    }
}