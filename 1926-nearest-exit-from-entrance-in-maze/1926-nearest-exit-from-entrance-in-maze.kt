class Solution {
    
    
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val dx = arrayOf(1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, -1)
        val queue = ArrayDeque<List<Int>>()
        val visited = Array(maze.size) { BooleanArray(maze[0].size) { false } }
        
        queue.add(listOf(entrance[0], entrance[1], 0))
        visited[entrance[0]][entrance[1]] = true
        
        val gx = listOf(0, maze.size - 1)
        val gy = listOf(0, maze[0].size - 1)
        
        while(queue.isNotEmpty()) {
            val (x, y, d) = queue.removeFirst()
            
            repeat(4) {
                val nx = x + dx[it]
                val ny = y + dy[it]
                
                if(nx in maze.indices && ny in maze[0].indices && maze[nx][ny] == '.' && !visited[nx][ny]) {
                    if(nx in gx || ny in gy) return d+1
                    else {
                        visited[nx][ny] = true
                        queue.addLast(listOf(nx, ny, d+1))
                    }
                }
            }
        }
        
        return -1
    }
}