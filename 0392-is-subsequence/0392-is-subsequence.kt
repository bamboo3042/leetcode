class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        
        if(s.isEmpty()) return true
        if(s.length > t.length) return false
        
        for(j in t.indices) {
            if(s[i] == t[j]) i++
            if(i == s.length) break
        }
        
        return i == s.length
    }
}