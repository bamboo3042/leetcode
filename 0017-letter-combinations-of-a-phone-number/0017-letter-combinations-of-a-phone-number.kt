class Solution {

    var result = mutableListOf<String>()
    val board = mutableMapOf<Char, String>()
    lateinit var visited: BooleanArray

    fun letterCombinations(digits: String): List<String> {
        visited = BooleanArray(digits.length) {false}
        board['2'] = "abc"
        board['3'] = "def"
        board['4'] = "ghi"
        board['5'] = "jkl"
        board['6'] = "mno"
        board['7'] = "pqrs"
        board['8'] = "tuv"
        board['9'] = "wxyz"

        dfs(digits, 0, "")

        return result
    }

    fun dfs(digits: String, n: Int, str: String) {
        if (!visited.contains(false) && str.isNotEmpty()) {
            result.add(str)
            return
        }
        for (i in n until digits.length) {
            if (!visited[i]) {
                visited[i] = true
                board[digits[i]]!!.forEach {
                    dfs(digits, n+1, str+it)
                }
                visited[i] = false
            }
        }
    }
}