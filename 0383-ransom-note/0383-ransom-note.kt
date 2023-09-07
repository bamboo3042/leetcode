class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val arr = IntArray(26) {0}
        
        magazine.forEach {
            arr[it.code - 97]++
        }
        
        ransomNote.forEach {
            if(--arr[it.code -  97] < 0) return false
        }
        
        return true
    }
}