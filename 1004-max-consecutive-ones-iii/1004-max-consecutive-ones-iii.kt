class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0
        var count = 0
        
        while(right < nums.size) {
            if(nums[right] == 0) count++
            right++
            if(count > k) {
                if(nums[left] == 0) count--
                left++
            }
        }
        
        return right - left
    }
}