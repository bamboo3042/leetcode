class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var result = 0
        val dx = arrayOf(1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, -1)
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        
        grid.forEachIndexed { i, ints -> 
            ints.forEachIndexed { j, o -> 
                if(o == 2) queue.add(Triple(i, j, 0))
            }
        }
        
        while(queue.isNotEmpty()) {
            val (x, y, d) = queue.removeFirst()
            
            result = maxOf(result, d)
            
            repeat(4) {
                val nx = x + dx[it]
                val ny = y + dy[it]
                
                if(nx in grid.indices && ny in grid[0].indices && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2
                    queue.addLast(Triple(nx, ny, d+1))
                }
            }
        }
        
        grid.forEach { ints -> ints.forEach { o -> if(o == 1) return -1 } }
        
        return result
    }
}