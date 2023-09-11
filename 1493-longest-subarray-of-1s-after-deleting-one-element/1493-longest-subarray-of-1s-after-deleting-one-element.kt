class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var left = 0
        var right = 0
        var count = 0
        
        while(right < nums.size) {
            if(nums[right] == 0) count++
            if(count > 1) {
                if(nums[left] == 0) count--
                left++
            }
            right++
        }
        
        return right - left - 1
    }
}