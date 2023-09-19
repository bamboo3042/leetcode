class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        var answer = 0
        val road = mutableMapOf<Int, MutableList<Int>>()
        val reversRoad = mutableMapOf<Int, MutableList<Int>>()
        val visited = BooleanArray(n) { false }
        val queue = ArrayDeque<Int>()

        repeat(n) {
            road[it] = mutableListOf()
            reversRoad[it] = mutableListOf()
        }
        connections.forEach { (a, b) ->
            road[a]!!.add(b)
            reversRoad[b]!!.add(a)
        }

        visited[0] = true
        queue.add(0)

        while(queue.isNotEmpty()) {
            val temp = queue.removeFirst()

            reversRoad[temp]!!.forEach { index ->
                if(!visited[index]) {
                    visited[index] = true
                    queue.add(index)
                }
            }

            road[temp]!!.forEach { index ->
                if(!visited[index]) {
                    visited[index] = true
                    answer++
                    queue.add(index)
                }
            }
        }

        return answer
    }
}