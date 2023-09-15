class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size) { false }
        val queue = ArrayDeque<Int>()
        queue.addLast(0)
        visited[0] = true
        
        while(queue.isNotEmpty()) {
            val temp = queue.removeFirst()
            
            rooms[temp].forEach {
                if(!visited[it]) {
                    queue.addLast(it)
                    visited[it] = true
                }
            }
        }
        
        return !visited.contains(false)
    }
}