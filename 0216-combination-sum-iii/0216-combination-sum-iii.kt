class Solution {
    
    val visited = BooleanArray(10) { false }
    val answer = mutableListOf<List<Int>>()
    
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        dfs(k, n, 1, listOf())
        
        return answer
    }
    
    fun dfs(k: Int, n: Int, t: Int, l: List<Int>) {
        if(l.size == k) {
            if(l.sum() == n) answer.add(l)
            return
        }
        
        for(i in t .. 9) {
            if(!visited[i]) {
                visited[i] = true
                dfs(k, n, i+1, l + i)
                visited[i] = false
            }
        }
    }
}