class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = mutableMapOf<String, MutableMap<String, Double>>()

        for (i in equations.indices) {
            val (a, b) = equations[i]
            val value = values[i]
            graph.computeIfAbsent(a) { mutableMapOf() }[b] = value
            graph.computeIfAbsent(b) { mutableMapOf() }[a] = 1 / value
        }

        val results = mutableListOf<Double>()
        for (query in queries) {
            val result = dfs(graph, query[0], query[1], mutableSetOf())
            results.add(if (result != null) result else -1.0)
        }

        return results.toDoubleArray()
    }

    private fun dfs(graph: Map<String, Map<String, Double>>, start: String, end: String, visited: MutableSet<String>): Double? {
        if (start !in graph || end !in graph || start in visited) return null
        if (start == end) return 1.0

        visited.add(start)
        for ((next, value) in graph[start]!!) {
            val subResult = dfs(graph, next, end, visited)
            if (subResult != null) {
                visited.remove(start)
                return value * subResult
            }
        }
        visited.remove(start)
        return null
    }
}
