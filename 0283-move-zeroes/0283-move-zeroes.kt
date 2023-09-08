class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var zero = 0
        var int = 0

        while(zero < nums.size && int < nums.size) {
            while(zero < nums.size && nums[zero] != 0) zero++
            while(int < nums.size && nums[int] == 0) int++

            if(zero < nums.size && int < nums.size) {
                if(zero < int) {
                    val temp = nums[zero]
                    nums[zero] = nums[int]
                    nums[int] = temp                    
                }
                else int = zero+1
            }
        }
    }
}